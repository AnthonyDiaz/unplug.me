package com.unplugme.model;

public class Ailments {

    public static final String TABLE_NAME = "ailments";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";

    private int id;
    private String title;
    private String description;

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TITLE + " TEXT, " + COLUMN_DESCRIPTION + " TEXT)";

    public Ailments(){

    }

    public Ailments(int id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getAilmentsId() {
        return id;
    }

    public void setAilmentsId(int id) {
        this.id = id;
    }

    public String getAilmentsTitle() {
        return title;
    }

    public void setAilmentsTitle(String title) {
        this.title = title;
    }

    public String getAilmentsDescription() {
        return description;
    }

    public void setAilmentsDescription(String description) {
        this.description = description;
    }

//    String sqlstr5 = "INSERT INTO " + AILMENTS_TABLE + " (" + TITLE_COLUMN + ", " + DESCRIPTION_COLUMN + ") VALUES " +
//            "('Carpal Tunnel Syndrome', 'It`s caused by pressure on your median nerve, which runs " +
//            "the length of the arm, goes through a passage in the wrist called the carpal tunnel, and ends in the hand. " +
//            "The median controls the movement and feeling of your thumb, and also the movement of all your fingers except your pinky. " +
//            "Repetitive motions, like typing or any motions of the wrist that you do over and over. " +
//            "This is especially true of actions when your hands are lower than your wrist.')," +
//
//            "('Chronic Neck Pain', 'Common symptoms associated with neck pain usually involves one or more of the following:  " +
//            "Stiff neck, soreness and difficulty moving the neck, especially when trying to turn the head from side to side. " +
//            "Sharp pain, can be pain localized to one spot and might feel like it’s stabbing or stinging. " +
//            "Often, this type of pain occurs in the lower levels of the neck. " +
//            "General soreness, the pain is mostly in one spot or area on the neck, and it’s described as tender or achy, not sharp. " +
//            "Radiating pain, the pain can radiate along a nerve from the neck into the shoulders and arms. " +
//            "The intensity can vary and this nerve pain might feel like it’s burning or searing. " +
//            "Tingling, numbness, or weakness. These sensations can go beyond the neck and radiate into the shoulder, arm or finger. " +
//            "There could be a “pins-and-needles” sensation but typically, pain that radiates down the arm is felt in only one arm, not both. " +
//            "Trouble with gripping or lifting objects can happen if tingling, numbness, or weakness in the fingers is present. " +
//            "Headaches can be caused by an irritation in the neck which is affecting muscles and nerves connected to the head.')," +
//
//            "('Tension Headaches', 'Neck muscles tightening, or occipital neuralgia, where a pinched occipital nerve in the neck causes " +
//            "pain to radiate up into the head’s sides and scalp.')";
}
