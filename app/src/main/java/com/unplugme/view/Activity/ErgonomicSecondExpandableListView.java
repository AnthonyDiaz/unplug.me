package com.unplugme.view.Activity;

import android.content.Context;
import android.widget.ExpandableListView;

public class ErgonomicSecondExpandableListView extends ExpandableListView{

    public ErgonomicSecondExpandableListView(Context context) {
        super(context);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(999999, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
