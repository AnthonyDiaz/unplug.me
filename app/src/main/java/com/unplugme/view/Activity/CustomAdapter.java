package com.unplugme.view.Activity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.unplugme.R;

import java.util.ArrayList;

class CustomAdapter extends  ArrayAdapter<String> {

public CustomAdapter(@NonNull android.support.v4.app.FragmentActivity context, ArrayList<String> scheduledBreaksList) {
        super(context, R.layout.custom_alert_row ,scheduledBreaksList);
        }

//custom view menu
@Override
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater rowInflater = LayoutInflater.from(getContext());
        View customView = rowInflater.inflate(R.layout.custom_alert_row, (parent), false);

        //create variables to hold Alert Title string and identify TextView on layout
        String singleScheduleTitle = getItem(position);
        TextView rowTitleText = customView.findViewById(R.id.lblAlertTitle);

        //set text to TextView on layout
        rowTitleText.setText(singleScheduleTitle);

        return customView;
        }
}
