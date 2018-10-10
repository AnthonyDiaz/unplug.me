package com.unplugme.view.Activity;


import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.unplugme.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilerMenuFragment extends android.support.v4.app.Fragment {
    private EditText ageInput, hrsWrkPerDayInput, wrkStartTime, avgBrTime, continHrsWrk_WOB;
    private Button saveProfileInfoButton;

    public Map<String, String> profileInformation = new HashMap<>();
    public ArrayAdapter<String> adapter;
    public ArrayList<String> list = new ArrayList<>();
    public String[] Days = {"Days Worked", "1", "2", "3", "4", "5", "6", "7"};
    public String[] DeskTime = {"Time spent siting at a Desk", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
                                    "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};



    public ProfilerMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_profiler_menu, container, false);

        ageInput = (EditText) rootView.findViewById(R.id.txt_usr_age);
        hrsWrkPerDayInput = (EditText) rootView.findViewById(R.id.usr_wrk_hrs_perday);
        wrkStartTime = (EditText) rootView.findViewById(R.id.usr_wrk_strt_time);
        avgBrTime = (EditText) rootView.findViewById(R.id.usr_avg_brk_time);
        continHrsWrk_WOB = (EditText) rootView.findViewById(R.id.usr_cont_wrk_hrs);

        saveProfileInfoButton = (Button) rootView.findViewById(R.id.save_button);
        saveProfileInfoButton.setTextColor(Color.GRAY);
        saveProfileInfoButton.setEnabled(false);

        List<String> daysWorded = new ArrayList<>(Arrays.asList(Days));
        List<String> deskTimeSpent = new ArrayList<>(Arrays.asList(DeskTime));


        Spinner daysWorkSpinner = (Spinner) rootView.findViewById(R.id.usr_days_wrk);
        Spinner deskTimeSpentSpinner = (Spinner) rootView.findViewById(R.id.usr_time_spnt);

        ArrayAdapter<String> DWadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, daysWorded){
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        final ArrayAdapter<String> DTSadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, deskTimeSpent)
        {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint

                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv2 = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv2.setTextColor(Color.GRAY);
                } else {
                    tv2.setTextColor(Color.BLACK);
                }
                return view;
            }
        }
;
        DWadapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        DTSadapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        daysWorkSpinner.setAdapter(DWadapter);
        deskTimeSpentSpinner.setAdapter(DTSadapter);


        EditText[] edList = {ageInput, hrsWrkPerDayInput, wrkStartTime, avgBrTime, continHrsWrk_WOB};
        CustomTextWatcher textWatcher = new CustomTextWatcher(edList, saveProfileInfoButton);

        for (EditText editText : edList) editText.addTextChangedListener(textWatcher);

        saveProfileInfoButton.setOnClickListener(saveButtonListener);

        if(!profileInformation.isEmpty()) {
//            Context context = getContext();
//            Toast toast = Toast.makeText(context, "Data in the dictionary!", Toast.LENGTH_SHORT);
//            toast.show();

        }else{
//            Context context = getContext();
//            Toast toast = Toast.makeText(context, "No Data in the dictionary!", Toast.LENGTH_SHORT);
//            toast.show();
        }

        displayProfileInfo(rootView);

        return rootView;
    }



    public void displayProfileInfo(View view){

        if(!profileInformation.isEmpty()){
            ageInput.setText(profileInformation.get(ageInput.getHint().toString()));
            hrsWrkPerDayInput.setText(profileInformation.get(hrsWrkPerDayInput.getHint().toString()));
            wrkStartTime.setText(profileInformation.get(wrkStartTime.getHint().toString()));
            avgBrTime.setText(profileInformation.get(avgBrTime.getHint().toString()));
            continHrsWrk_WOB.setText(profileInformation.get(continHrsWrk_WOB.getHint().toString()));
        }
    }


    public View.OnClickListener saveButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(ageInput.getText() != null && hrsWrkPerDayInput.getText() != null && wrkStartTime.getText() != null && avgBrTime.getText() != null && continHrsWrk_WOB.getText() != null){
                profileInformation.put(ageInput.getHint().toString(), ageInput.getText().toString());
                profileInformation.put(hrsWrkPerDayInput.getHint().toString(), hrsWrkPerDayInput.getText().toString());
                profileInformation.put(wrkStartTime.getHint().toString(), wrkStartTime.getText().toString());
                profileInformation.put(avgBrTime.getHint().toString(), avgBrTime.getText().toString());
                profileInformation.put(continHrsWrk_WOB.getHint().toString(), continHrsWrk_WOB.getText().toString());
                Context context = getContext();
                Toast toast = Toast.makeText(context, "Data has been saved!!!", Toast.LENGTH_SHORT);
                toast.show();

                Double workHoursPerDay = Double.parseDouble(profileInformation.get(hrsWrkPerDayInput.getHint().toString()));
                Double contWorkHoursWithoutBreak = Double.parseDouble(profileInformation.get(hrsWrkPerDayInput.getHint().toString()));
                String WorkStartTime = profileInformation.get(wrkStartTime.getHint().toString());

//                //call methods to generate break info from profile
//                SchedulerFragment schedulerFragment = new SchedulerFragment();
//                schedulerFragment.generateBreakLength(workHoursPerDay, contWorkHoursWithoutBreak);
//                schedulerFragment.generateBreakStartTime(WorkStartTime);
//                schedulerFragment.createBreakStrings(workHoursPerDay);

                saveProfileInfoButton.setEnabled(false);
                saveProfileInfoButton.setTextColor(Color.GRAY);
            }else{

            }

        }
    };

    private class CustomTextWatcher implements TextWatcher {
        private Button bv;
        private EditText[] edList;

        public CustomTextWatcher(EditText[] edList, Button bv){
            this.edList = edList;
            this.bv = bv;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            for (EditText editText : edList){
                if(!profileInformation.isEmpty()){

                }else{
                    Context context = getContext();
//                    Toast toast = Toast.makeText(context, "Please Enter your profile information", Toast.LENGTH_SHORT);
//                    toast.show();
                }
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            for (EditText editText : edList) {
                if (editText.getText().toString().trim().length() <= 0) {
                    bv.setEnabled(false);
                    break;
                } else {
                    bv.setEnabled(true);
                    bv.setTextColor(Color.WHITE);
                }

            }

        }
    }
}
