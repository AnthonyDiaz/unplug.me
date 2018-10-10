package com.unplugme.view.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.unplugme.R;
import com.unplugme.model.Ailments;
import com.unplugme.model.Ergonomics;
import com.unplugme.model.TipsTricks;
import com.unplugme.sqlite.DatabaseHandler;
import com.unplugme.view.adapter.ThreeLevelListAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ErgonomicsFragment extends android.support.v4.app.Fragment  {
    private static final String LOG = "ErgonomicsFragment";
    View view;
    DatabaseHandler db;

    private ExpandableListView expandableListView;
    String[] parent = new String[]{"Ergonomics", "Ailments", "Tips and Tricks"};

    LinkedHashMap thirdLevelq1 = new LinkedHashMap<>();
    LinkedHashMap thirdLevelq2 = new LinkedHashMap<>();
    LinkedHashMap thirdLevelq3 = new LinkedHashMap<>();

    List<String[]> secondLevel = new ArrayList();

    List<LinkedHashMap<String, String[]>> data = new ArrayList<>();



    public ErgonomicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ergonomics, container, false);
        db = new DatabaseHandler(this.getContext());
        setUpAdapter();

        return view;
    }

    private void setUpAdapter() {

        db.getReadableDatabase();
        String[] q1 = db.getAllSubCategories(Ergonomics.COLUMN_TITLE, Ergonomics.TABLE_NAME);
        String[] q2 = db.getAllSubCategories(Ailments.COLUMN_TITLE, Ailments.TABLE_NAME);
        String[] q3 = db.getAllSubCategories(TipsTricks.COLUMN_TITLE, TipsTricks.TABLE_NAME);
        String[] des1 = new String[]{"The monitor should be an arm`s length away from you."};
        String[] des2 = new String[]{"The top of the monitor should be at eye level."};
        String[] des3 = new String[]{"Light positioning will depend on desk placement and monitor height," +
                                    " as well as if you are next to a window and how brightly the sun shines in."};
        String[] des4 = new String[]{"It`s caused by pressure on your median nerve, which runs the" +
                                    " length of the arm, goes through a passage in the wrist called the" +
                                    " carpal tunnel, and ends in the hand. The median controls the " +
                                    "movement and feeling of your thumb, and also the movement of " +
                                    "all your fingers except your pinky. Repetitive motions, like " +
                                    "typing or any motions of the wrist that you do over and over. "+
                                    "This is especially true of actions when your hands are lower " +
                                    "than your wrist."};
        String[] des5 = new String[]{"Common symptoms associated with neck pain usually involves one or more of the following: "+
                                    "Stiff neck, soreness and difficulty moving the neck, especially when trying to turn the head from side to side. "+
                                    "Sharp pain, can be pain localized to one spot and might feel like it’s stabbing or stinging. "+
                                    "Often, this type of pain occurs in the lower levels of the neck. "+
                                    "General soreness, the pain is mostly in one spot or area on " +
                                    "the neck, and it’s described as tender or achy, not sharp. "+
                                    "Radiating pain, the pain can radiate along a nerve from the " +
                                    "neck into the shoulders and arms. The intensity can vary and " +
                                    "this nerve pain might feel like it’s burning or searing. "+
                                    "Tingling, numbness, or weakness. These sensations can go " +
                                    "beyond the neck and radiate into the shoulder, arm or finger. "+
                                    "There could be a “pins-and-needles” sensation but typically, " +
                                    "pain that radiates down the arm is felt in only one arm, not both. "+
                                    "Trouble with gripping or lifting objects can happen if " +
                                    "tingling, numbness, or weakness in the fingers is present. "+
                                    "Headaches can be caused by an irritation in the neck which is " +
                                    "affecting muscles and nerves connected to the head."};
        String[] des6 = new String[]{"Neck muscles tightening, or occipital neuralgia, where a " +
                                    "pinched occipital nerve in the neck causes pain to radiate up " +
                                    "into the head’s sides and scalp."};
        String[] des7 = new String[]{"Strains are injuries related to muscles whereas Sprains are injuries related to the ligaments."};
        String[] des8 = new String[]{"Avoid eye strain by making sure that your monitor is not too close, it should be at least an arm`s length away."};
        String[] des9 = new String[]{"Rule of thumb to avoid excessive eyestrain: after 20 minutes, look at an object 20 feet away for 20 seconds."};
        String[] des10 = new String[]{"The healthy body can only tolerate staying in one position " +
                                      "for about 20 minutes. Standing in one place, such as " +
                                    "standing on a concrete floor at an assembly line for extended " +
                                    "periods of time tends to cause back pain. Holding the same " +
                                    "position slowly diminishes elasticity in the soft tissues " +
                                    "(muscles, ligaments, and tendons in the back). Then, stress " +
                                    "builds up and causes back discomfort and/or leg discomfort. " +
                                    "Change positions frequently. Just move. Stand or sit, stretch, " +
                                    "take a short walk. After returning to the standing or sitting " +
                                    "posture, use an alternate posture for just a few moments " +
                                    "and some of the tissue elasticity needed to protect the joints " +
                                    "will return."};
        String[] des11 = new String[]{"Maintaining the natural curve of the spine when standing " +
                                    "promotes good posture. Keep your head directly over the shoulders, " +
                                    "keep the shoulders directly over the pelvis, tighten the core " +
                                    "abdominal muscles, tuck in the gluteal muscles, and place the " +
                                    "feet slightly apart, with one foot positioned slightly in " +
                                    "front of the other and knees bent just a little bit."};
        String[] des12 = new String[]{"Posture is important for sitting in office chairs and at a " +
                                    "workstation. Many of us spend hours in front of the computer, " +
                                    "resulting in back pain or neck pain. Much of this pain may be " +
                                    "avoided by adjusting your workspace using these tips: Choose " +
                                    "the surface height for the desk (standing, sitting or " +
                                    "semi-seated) best for the task to be performed. Architects " +
                                    "and draftsman may want a higher surface for drawing while " +
                                    "computer entry work could be seated or standing, depending on " +
                                    "the need to use other tools or references. The specific height " +
                                    "of the work surface will also need to vary based on the height " +
                                    "of the individual worker. Adjust the seat of the office chair " +
                                    "so that the work surface is elbow high. A fist should be able " +
                                    "to pass easily behind the calf and in front of the seat edge " +
                                    "to keep the back of the legs from being pressed too hard and " +
                                    "the feet from swelling. Two fingers should slip easily under " +
                                    "each thigh. If not, use a couple of telephone books or a " +
                                    "footrest to raise the knees level with the hips. The backrest " +
                                    "of the office chair should push the low back forward slightly. " +
                                    "If these adjustments cannot be adequately made with the existing " +
                                    "office chair, a different make or type of chair may be considered. "+
                                    "Fit the height of the computer screen. Sit comfortably in the newly " +
                                    "adjusted office chair. Close both eyes and relax. Then, " +
                                    "slowly reopen them. Where the gaze initially focuses should be "+
                                    "when the eyes open is the place to put the center of the " +
                                    "computer screen. The screen can be raised using books or a " +
                                    "stand if needed."};


        secondLevel.add(q1);
        secondLevel.add(q2);
        secondLevel.add(q3);


        thirdLevelq1.put(q1[0], des1);
        thirdLevelq1.put(q1[1], des2);
        thirdLevelq1.put(q1[2], des3);

        thirdLevelq2.put(q2[0], des4);
        thirdLevelq2.put(q2[1], des5);
        thirdLevelq2.put(q2[2], des6);

        thirdLevelq3.put(q3[0], des7);
        thirdLevelq3.put(q3[1], des8);
        thirdLevelq3.put(q3[2], des9);
        thirdLevelq3.put(q3[3], des10);
        thirdLevelq3.put(q3[4], des11);
        thirdLevelq3.put(q3[5], des12);

        data.add(thirdLevelq1);
        data.add(thirdLevelq2);
        data.add(thirdLevelq3);

        expandableListView = (ExpandableListView) view.findViewById(R.id.expandible_listview);
        //passing the three level of information to the constructor
        ThreeLevelListAdapter threeLevelListAdapter = new ThreeLevelListAdapter(this.getContext(), parent,  secondLevel,  data);
        expandableListView.setAdapter(threeLevelListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;
            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousGroup)
                    expandableListView.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }

            });

    }
}

