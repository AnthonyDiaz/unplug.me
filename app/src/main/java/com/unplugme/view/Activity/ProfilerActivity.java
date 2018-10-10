/**
 *
 */

package com.unplugme.view.Activity;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;

import com.unplugme.R;
import com.unplugme.utility.Utility;
import com.unplugme.utility.ZoomOutPageTransformer;
import com.unplugme.view.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class ProfilerActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ListView scheduleListView ;
    private CustomAdapter listAdapter ;

    private int[] tabIcons = {
            R.drawable.more_details_48_gray,
            R.drawable.more_details_48_white,
            R.drawable.schedule_48_gray,
            R.drawable.schedule_48_white,
            R.drawable.contract_job_gray,
            R.drawable.contract_job_white
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiler);


        tabLayout = (TabLayout) findViewById(R.id.navigation_tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager_fragment_container);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Adding Fragments
        adapter.AddFragment(new ErgonomicsFragment(), "Info");
        adapter.AddFragment(new SchedulerFragment(), "Schedule");
        adapter.AddFragment(new ProfilerMenuFragment(), "Profile");
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        setupTabsAndIcons();

    }

        @Override
        protected void onResume () {
            super.onResume();

            View rootView = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
            rootView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        Utility.hideKeyboard(ProfilerActivity.this);
                    }
                }
            });
        }

    private void setupTabsAndIcons(){
        tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.profilebackground), ContextCompat.getColor(this,  android.R.color.white));
        tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.menubarbackground));
        tabLayout.getTabAt(0).setIcon(tabIcons[1]);
        tabLayout.getTabAt(1).setIcon(tabIcons[3]);
        tabLayout.getTabAt(2).setIcon(tabIcons[5]);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        final int hour = hourOfDay;
        final int minutes = minute;

        final EditText taskEditText = new EditText(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(hourOfDay + ":" + minute + " break");
        builder.setMessage("What will you name the break?");
        builder.setView(taskEditText);
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(DialogInterface dialog, int which) {

                scheduleListView =  findViewById(R.id.listView_todo);

                // Create and populate a List of scheduled breaks.
                String[] scheduledBreaks = new String[]{""};
                ArrayList<String> scheduledBreaksList = new ArrayList<String>();
                scheduledBreaksList.addAll(Arrays.asList(scheduledBreaks));

                // Create custom List Adapter using the breaks list.
                //listAdapter = new CustomAdapter(SchedulerFragment.this, scheduledBreaksList);
                listAdapter = new CustomAdapter(ProfilerActivity.this, scheduledBreaksList);

                // Set the Custom Adapter as the ListView's adapter.
                scheduleListView.setAdapter(listAdapter);

                // Add the break name and time. If you passed a String[] instead of a List<String>
                // into the custom Adapter constructor, you must not add more items.
                // Otherwise an exception will occur.
                listAdapter.add(taskEditText.getText().toString() + " " + hour + ":" + minutes);
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.setNeutralButton("Change Time", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "Edit Time");
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
