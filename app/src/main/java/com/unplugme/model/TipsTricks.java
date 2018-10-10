package com.unplugme.model;

import java.util.HashMap;
import java.util.Map;

public class TipsTricks {

    public static final String TABLE_NAME = "tips_tricks";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";

    private int id;
    private String title;
    private String description;

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TITLE + " TEXT, " + COLUMN_DESCRIPTION + " TEXT)";

    Map<String, String> tipsTricksItmes = new HashMap<>();

    public TipsTricks(){

    }

    public TipsTricks(int id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getTipsTricksId() {
        return id;
    }

    public void setTipsTricksId(int id) {
        this.id = id;
    }

    public String getTipsTricksTitle() {
        return title;
    }

    public void setTipsTricksTitle(String title) {
        this.title = title;
    }

    public String getTipsTricksDescription() {
        return description;
    }

    public void setTipsTricksDescription(String description) {
        this.description = description;
    }

    private void setTipsTricksItmesItmes(){
        tipsTricksItmes.put("Strains vs Sprains", "Strains are injuries related to muscles whereas Sprains are injuries related to the ligaments.");
        tipsTricksItmes.put("Eye Strain", "Strains are injuries related to muscles whereas Sprains are injuries related to the ligaments.");
        tipsTricksItmes.put("20/20/20", "Rule of thumb to avoid excessive eyestrain: after 20 minutes, look at an object 20 feet away for 20 seconds.");
        tipsTricksItmes.put("Static Posture", "The healthy body can only tolerate staying in one position for about 20 minutes. " +
                "Standing in one place, such as standing on a concrete floor at an assembly line for extended periods of time tends to cause back pain. " +
                "Holding the same position slowly diminishes elasticity in the soft tissues (muscles, ligaments, and tendons in the back). " +
                "Then, stress builds up and causes back discomfort and/or leg discomfort. Change positions frequently. Just move. " +
                "Stand or sit, stretch, take a short walk. After returning to the standing or sitting posture, " +
                "use an alternate posture for just a few moments and some of the tissue elasticity needed to protect the joints will return.");
        tipsTricksItmes.put("Good Posture while Standing", "Maintaining the natural curve of the spine when standing promotes good posture. " +
                "Keep your head directly over the shoulders, keep the shoulders directly over the pelvis, " +
                "tighten the core abdominal muscles, tuck in the gluteal muscles, and place the feet slightly apart, " +
                "with one foot positioned slightly in front of the other and knees bent just a little bit.");
        tipsTricksItmes.put("Good Posture while Sitting", "Posture is important for sitting in office chairs and at a workstation. " +
                "Many of us spend hours in front of the computer, resulting in back pain or neck pain. " +
                "Much of this pain may be avoided by adjusting your workspace using these tips: " +
                "Choose the surface height for the desk (standing, sitting or semi-seated) best for the task to be performed. " +
                "Architects and draftsman may want a higher surface for drawing while computer entry work could be seated or standing, " +
                "depending on the need to use other tools or references. " +
                "The specific height of the work surface will also need to vary based on the height of the individual worker. " +
                "Adjust the seat of the office chair so that the work surface is elbow high. " +
                "A fist should be able to pass easily behind the calf and in front of the seat edge to keep " +
                "the back of the legs from being pressed too hard and the feet from swelling. " +
                "Two fingers should slip easily under each thigh. If not, use a couple of telephone books \" +\n" +
                "or a footrest to raise the knees level with the hips. " +
                "The backrest of the office chair should push the low back forward slightly. " +
                "If these adjustments cannot be adequately made with the existing office chair, a different make or type of chair may be considered. " +
                "Fit the height of the computer screen. Sit comfortably in the newly adjusted office chair. " +
                "Close both eyes and relax. Then, slowly reopen them. Where the gaze initially focuses should be " +
                "when the eyes open is the place to put the center of the computer screen. The screen can be raised using books or a stand if needed.");
    }


//    String sqlstr4 = "INSERT INTO " + TIPS_TRICKS_TABLE + " (" + TITLE_COLUMN + ", " + DESCRIPTION_COLUMN + ") VALUES " +
//
//            "('Strains vs Sprains', 'Strains are injuries related to muscles whereas Sprains are injuries related to the ligaments.')," +
//
//            "('Eye Strain', 'Avoid eye strain by making sure that your monitor is not too close, it should be at least an arm`s length away.')," +
//
//            "('20/20/20', 'Rule of thumb to avoid excessive eyestrain: after 20 minutes, look at an object 20 feet away for 20 seconds.')," +
//
//            "('Static Posture', 'The healthy body can only tolerate staying in one position for about 20 minutes. " +
//            "Standing in one place, such as standing on a concrete floor at an assembly line for extended periods of time tends to cause back pain. " +
//            "Holding the same position slowly diminishes elasticity in the soft tissues (muscles, ligaments, and tendons in the back). " +
//            "Then, stress builds up and causes back discomfort and/or leg discomfort. Change positions frequently. Just move. " +
//            "Stand or sit, stretch, take a short walk. After returning to the standing or sitting posture, " +
//            "use an alternate posture for just a few moments and some of the tissue elasticity needed to protect the joints will return.')," +
//
//            "('Good Posture while Standing', 'Maintaining the natural curve of the spine when standing promotes good posture. " +
//            "Keep your head directly over the shoulders, keep the shoulders directly over the pelvis, " +
//            "tighten the core abdominal muscles, tuck in the gluteal muscles, and place the feet slightly apart, " +
//            "with one foot positioned slightly in front of the other and knees bent just a little bit.')," +
//
//            "('Good Posture while Sitting', 'Posture is important for sitting in office chairs and at a workstation. " +
//            "Many of us spend hours in front of the computer, resulting in back pain or neck pain. " +
//            "Much of this pain may be avoided by adjusting your workspace using these tips: " +
//            "Choose the surface height for the desk (standing, sitting or semi-seated) best for the task to be performed. " +
//            "Architects and draftsman may want a higher surface for drawing while computer entry work could be seated or standing, " +
//            "depending on the need to use other tools or references. " +
//            "The specific height of the work surface will also need to vary based on the height of the individual worker. " +
//            "Adjust the seat of the office chair so that the work surface is elbow high. " +
//            "A fist should be able to pass easily behind the calf and in front of the seat edge to keep " +
//            "the back of the legs from being pressed too hard and the feet from swelling. " +
//            "Two fingers should slip easily under each thigh. If not, use a couple of telephone books " +
//            "or a footrest to raise the knees level with the hips. " +
//            "The backrest of the office chair should push the low back forward slightly. " +
//            "If these adjustments cannot be adequately made with the existing office chair, a different make or type of chair may be considered. " +
//            "Fit the height of the computer screen. Sit comfortably in the newly adjusted office chair. " +
//            "Close both eyes and relax. Then, slowly reopen them. Where the gaze initially focuses should be " +
//            "when the eyes open is the place to put the center of the computer screen. The screen can be raised using books or a stand if needed.')";
//        db.execSQL(sqlstr4);
}
