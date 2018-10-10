package com.unplugme.view.Activity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.unplugme.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.HOUR;


/**
 * A simple {@link Fragment} subclass.
 */
public class SchedulerFragment extends android.support.v4.app.Fragment {
    View view;
    static final String LOG_TAG = "Debug Logging here.";
    private static final String DIALOG_TIME = "MainActivity.TimeDialog";
    //    public ListView scheduleListView = (ListView) view.findViewById(R.id.list_todo);
    private ListView listView;
    private double breakLength;
    CustomAdapter customAdapter;
    static Date breakStartTime = new Date();
    ArrayList<String> scheduledBreaksList = new ArrayList<String>();


    public SchedulerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_scheduler, container, false);
        // Inflate the layout for this fragment
        listView = (ListView) view.findViewById(R.id.listView_todo);
        customAdapter = new CustomAdapter (getActivity(), scheduledBreaksList);
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.floatingActionButton3);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddButtonSelected(view);
            }
        });
        return view;
    }


    public boolean onAddButtonSelected(final View v)
    {
        AlertDialog dialog = new AlertDialog.Builder(v.getContext())
                .setTitle("Add a new scheduled break")
                .setMessage("Please select a time...")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Time", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        DialogFragment timePicker = new TimePickerFragment();
                        timePicker.show(getActivity().getSupportFragmentManager(), "Time Picker");
                    }
                })
                .create();
        dialog.show();
        return true;
    }

    //    // new method for editing alert - in progress
//    public boolean onEditButtonSelected(View v)
//    {
//        AlertDialog dialog = new AlertDialog.Builder(v.getContext())
//                .setTitle("Add a new scheduled break")
//                .setMessage("Please select a time...")
//                .setNegativeButton("Cancel", null)
//                .setPositiveButton("Time", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        TimePickerFragment dialog = new TimePickerFragment();
//                        dialog.show(getActivity().getFragmentManager(), DIALOG_TIME);
//                    }
//                })
//                .create();
//        dialog.show();
//        return true;
//    }

    public void generateBreakLength(double workHoursPerDay, double contWorkHoursWithoutBreak) {
        double modBreakTimeWorkDayHours = 0;
        double modBreakTimeContWorkHours = 1.5;

        //modify Break Time for Continuous Hours without break
        if (contWorkHoursWithoutBreak >= 1 && contWorkHoursWithoutBreak <= 2)
            modBreakTimeContWorkHours =  -0.5;
        else if (contWorkHoursWithoutBreak >= 3 && contWorkHoursWithoutBreak <= 4)
            modBreakTimeContWorkHours = 0;
        else if (contWorkHoursWithoutBreak >= 5 && contWorkHoursWithoutBreak <= 6)
            modBreakTimeContWorkHours = 0.5;
        else if (contWorkHoursWithoutBreak >= 7 && contWorkHoursWithoutBreak <= 8)
            modBreakTimeContWorkHours = 1;
        else if (contWorkHoursWithoutBreak >= 9)
            modBreakTimeContWorkHours = 1.5;

        //modify break time for Work Hours per Day
        if (workHoursPerDay  >= 1 && workHoursPerDay  <= 4)
            modBreakTimeWorkDayHours =  -0.5;
        else if (workHoursPerDay  >= 5 && workHoursPerDay  <= 8)
            modBreakTimeWorkDayHours = 0;
        else if (workHoursPerDay  >= 9 && workHoursPerDay  <= 12)
            modBreakTimeWorkDayHours = 0.5;
        else if (workHoursPerDay  >= 13)
            modBreakTimeWorkDayHours = 1;

        //calculate modified hourly breakLength
        double defaultBreakTime = 3.5;
        breakLength = defaultBreakTime + modBreakTimeWorkDayHours + modBreakTimeContWorkHours;

        String str2 = "method has been run";
        Log.d(LOG_TAG, str2);
    }

    public Date generateBreakStartTime(String WorkStartTime) {


        SimpleDateFormat dateFormat = new SimpleDateFormat("HHmm");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("hh:mm aa");

        Calendar gc = new GregorianCalendar();
        try {
            Date parsedWorkStartTime = dateFormat.parse(WorkStartTime);

            gc.setTime(parsedWorkStartTime);
            gc.add(HOUR, 2);
            breakStartTime = gc.getTime();

        } catch (ParseException e) {
        }
        Log.d(LOG_TAG, String.valueOf(breakStartTime));
        return breakStartTime;

    }

    public void createBreakStrings(double workHoursPerDay) {

        double amountOfBreaks = workHoursPerDay / 2;


        // Create and populate a List of scheduled breaks.
        String[] scheduledBreaks = new String[]{""};
        scheduledBreaksList.addAll(Arrays.asList(scheduledBreaks));

        // Create custom List Adapter using the breaks list.
        //listAdapter = new CustomAdapter(SchedulerFragment.this, scheduledBreaksList);

        if(getActivity() == null) {
            Log.d(LOG_TAG, "Activity is NULL!!!!!!!!");

        }
        if(getActivity() != null){
            customAdapter = new CustomAdapter(this.getActivity(), scheduledBreaksList);
        }
        // Set the Custom Adapter as the ListView's adapter.
        listView.setAdapter(customAdapter);

        Calendar gc = new GregorianCalendar();
        //Calendar moddedBreakStartTime = new GregorianCalendar();
        gc.setTime(breakStartTime);
        //logging purposes
        String str3 = "gc time has been set";
        String str4 = "executed a loop";
        Log.d(LOG_TAG, String.valueOf(breakStartTime));
        Log.d(LOG_TAG, String.valueOf(breakLength));
        Log.d(LOG_TAG, str3);

        for (int i = 0; i <= amountOfBreaks; i++)
        {
            //debug purpose
            Log.d(LOG_TAG, str4);

            gc.add(GregorianCalendar.HOUR, 2);
            String stringToAdd = (breakLength + " minute break at " + breakStartTime);
            //debug
            Log.d(LOG_TAG, stringToAdd);
            customAdapter.add(String.valueOf(stringToAdd));

            //debug to console
//            String str = Arrays.toString(new CustomAdapter[]{SchedulerFragment.listAdapter});
//            String str2 = "executed the createStrings logic";
            //System.out.println(str);
//            Log.d(LOG_TAG, str);
//            Log.d(LOG_TAG, str2);




        }
    }

}
