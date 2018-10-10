package com.unplugme.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.unplugme.helper.Description;
import com.unplugme.helper.SubCategory;
import com.unplugme.model.Ailments;
import com.unplugme.model.Ergonomics;
import com.unplugme.model.TipsTricks;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String LOG = "DatabaseHelper";                 // Logcat tag

    private static final int DB_VERSION = 1;                            // Database Version
    private static final String DB_NAME = "unplugme.db";                // Database Name

    private static final String KEY_ID = "id";
    private static final String TITLE_COLUMN = "title";
    private static final String DESCRIPTION_COLUMN = "description";


    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * Creating table from model classes.
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Creating Ergonomics Table
        db.execSQL(Ergonomics.CREATE_TABLE);
        Log.d(LOG,Ergonomics.TABLE_NAME + " created....");

        // Inserting into Ergonomics Table
        String insertQuery = "INSERT INTO " + Ergonomics.TABLE_NAME +
                " (" + Ergonomics.COLUMN_TITLE + ", " + Ergonomics.COLUMN_DESCRIPTION + ") VALUES " +
                "('Monitor`s Distance', 'The monitor should be an arm`s length away from you.')," +
                "('Monitor Height', 'The top of the monitor should be at eye level.')," +
                "('Lighting', 'Light positioning will depend on desk placement and monitor height, " +
                "as well as if you are next to a window and how brightly the sun shines in.')";
        db.execSQL(insertQuery);
        Log.d(LOG,"Data inserted into " + Ergonomics.TABLE_NAME + " table....");

        // Creating Ailments Table
        db.execSQL(Ailments.CREATE_TABLE);
        Log.d(LOG,Ailments.TABLE_NAME + " created....");
        String insertQuery2 = "INSERT INTO " + Ailments.TABLE_NAME + " (" + Ailments.COLUMN_TITLE + ", " + Ailments.COLUMN_DESCRIPTION + ") VALUES " +
            "('Carpal Tunnel Syndrome', 'It`s caused by pressure on your median nerve, which runs " +
            "the length of the arm, goes through a passage in the wrist called the carpal tunnel, and ends in the hand. " +
            "The median controls the movement and feeling of your thumb, and also the movement of all your fingers except your pinky. " +
            "Repetitive motions, like typing or any motions of the wrist that you do over and over. " +
            "This is especially true of actions when your hands are lower than your wrist.')," +

            "('Chronic Neck Pain', 'Common symptoms associated with neck pain usually involves one or more of the following:  " +
            "Stiff neck, soreness and difficulty moving the neck, especially when trying to turn the head from side to side. " +
            "Sharp pain, can be pain localized to one spot and might feel like it’s stabbing or stinging. " +
            "Often, this type of pain occurs in the lower levels of the neck. " +
            "General soreness, the pain is mostly in one spot or area on the neck, and it’s described as tender or achy, not sharp. " +
            "Radiating pain, the pain can radiate along a nerve from the neck into the shoulders and arms. " +
            "The intensity can vary and this nerve pain might feel like it’s burning or searing. " +
            "Tingling, numbness, or weakness. These sensations can go beyond the neck and radiate into the shoulder, arm or finger. " +
            "There could be a “pins-and-needles” sensation but typically, pain that radiates down the arm is felt in only one arm, not both. " +
            "Trouble with gripping or lifting objects can happen if tingling, numbness, or weakness in the fingers is present. " +
            "Headaches can be caused by an irritation in the neck which is affecting muscles and nerves connected to the head.')," +

            "('Tension Headaches', 'Neck muscles tightening, or occipital neuralgia, where a pinched occipital nerve in the neck causes " +
            "pain to radiate up into the head’s sides and scalp.')";
        db.execSQL(insertQuery2);
        Log.d(LOG,"Data inserted into " + Ailments.TABLE_NAME + " table....");

        // Creating TipsTricks Table
        db.execSQL(TipsTricks.CREATE_TABLE);
        Log.d(LOG,TipsTricks.TABLE_NAME + " created....");

            String insertQuery3 = "INSERT INTO " + TipsTricks.TABLE_NAME + " (" + TipsTricks.COLUMN_TITLE + ", " + TipsTricks.COLUMN_DESCRIPTION + ") VALUES " +

            "('Strains vs Sprains', 'Strains are injuries related to muscles whereas Sprains are injuries related to the ligaments.')," +

            "('Eye Strain', 'Avoid eye strain by making sure that your monitor is not too close, it should be at least an arm`s length away.')," +

            "('20/20/20', 'Rule of thumb to avoid excessive eyestrain: after 20 minutes, look at an object 20 feet away for 20 seconds.')," +

            "('Static Posture', 'The healthy body can only tolerate staying in one position for about 20 minutes. " +
            "Standing in one place, such as standing on a concrete floor at an assembly line for extended periods of time tends to cause back pain. " +
            "Holding the same position slowly diminishes elasticity in the soft tissues (muscles, ligaments, and tendons in the back). " +
            "Then, stress builds up and causes back discomfort and/or leg discomfort. Change positions frequently. Just move. " +
            "Stand or sit, stretch, take a short walk. After returning to the standing or sitting posture, " +
            "use an alternate posture for just a few moments and some of the tissue elasticity needed to protect the joints will return.')," +

            "('Good Posture while Standing', 'Maintaining the natural curve of the spine when standing promotes good posture. " +
            "Keep your head directly over the shoulders, keep the shoulders directly over the pelvis, " +
            "tighten the core abdominal muscles, tuck in the gluteal muscles, and place the feet slightly apart, " +
            "with one foot positioned slightly in front of the other and knees bent just a little bit.')," +

            "('Good Posture while Sitting', 'Posture is important for sitting in office chairs and at a workstation. " +
            "Many of us spend hours in front of the computer, resulting in back pain or neck pain. " +
            "Much of this pain may be avoided by adjusting your workspace using these tips: " +
            "Choose the surface height for the desk (standing, sitting or semi-seated) best for the task to be performed. " +
            "Architects and draftsman may want a higher surface for drawing while computer entry work could be seated or standing, " +
            "depending on the need to use other tools or references. " +
            "The specific height of the work surface will also need to vary based on the height of the individual worker. " +
            "Adjust the seat of the office chair so that the work surface is elbow high. " +
            "A fist should be able to pass easily behind the calf and in front of the seat edge to keep " +
            "the back of the legs from being pressed too hard and the feet from swelling. " +
            "Two fingers should slip easily under each thigh. If not, use a couple of telephone books " +
            "or a footrest to raise the knees level with the hips. " +
            "The backrest of the office chair should push the low back forward slightly. " +
            "If these adjustments cannot be adequately made with the existing office chair, a different make or type of chair may be considered. " +
            "Fit the height of the computer screen. Sit comfortably in the newly adjusted office chair. " +
            "Close both eyes and relax. Then, slowly reopen them. Where the gaze initially focuses should be " +
            "when the eyes open is the place to put the center of the computer screen. The screen can be raised using books or a stand if needed.')";
        db.execSQL(insertQuery3);
        Log.d(LOG,"Data inserted into " + TipsTricks.TABLE_NAME + " table....");

    }

    /**
     * On Upgrade drop existing table and recreate new table from model classes.
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        String sqlstr = "DROP TABLE IF EXISTS " + Ergonomics.CREATE_TABLE;
        db.execSQL(sqlstr);

        String sqlstr2 = "DROP TABLE IF EXISTS " + Ailments.CREATE_TABLE;
        db.execSQL(sqlstr2);

        String sqlstr3 = "DROP TABLE IF EXISTS " + TipsTricks.CREATE_TABLE;
        db.execSQL(sqlstr3);

        // create new tables
        onCreate(db);

    }


    public SubCategory getCategory( String column_names, final String table_name, int category_id){

        String selectQuery = "SELECT " + column_names + " FROM " + table_name + " WHERE id = " +
                            category_id ;
        Log.e(LOG, "Get Category Select Query: ( " + selectQuery + " )");

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery,  null);

        if (cursor != null)
            cursor.moveToFirst();

        // Prepare category object
        SubCategory ttc = new SubCategory();
                ttc.setCategoryItem(cursor.getString(cursor.getColumnIndex(column_names)));

        //Close the db connection
        cursor.close();

        return ttc;
    }


    public String[] getAllSubCategories(final String column_name, final String table_name){

        //Select All Query
        String selectQuery = "SELECT " + column_name +  " FROM " + table_name ;
        Log.e(LOG, "Get All SubCategory Select Query: ( " + selectQuery + " )");

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,  null);

        String[] subCategories = new String[cursor.getCount()];

        if(cursor.moveToFirst()){
            int i=0;
            do{
                String subCategory = cursor.getString(cursor.getColumnIndex(column_name));
                subCategories[i] = subCategory;
                i++;
            }while(cursor.moveToNext());
        }
//        subCategories.addAll(Collections.singleton(subCategory.toArray(new String[0])));
        cursor.close();
        return subCategories;
    }

    public String getDescription(final String column_name, final String table_name, int category_id){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT " + column_name + " FROM " + table_name + " WHERE id = "+
                            category_id;

        Log.e(LOG, "Get Description Select Query: ( " + selectQuery + " )");

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor != null)
            cursor.moveToFirst();

        String descripton = cursor.getString(cursor.getColumnIndex(column_name));
        return descripton;
    }


    public List<Description> getAllDescription(final String column_name, final String table_name){
        List<Description> descriptionsList = new ArrayList<Description>();
        String selectQuery = "SELECT " + column_name + " FROM " + table_name;

        Log.e(LOG,"Get All Description Select Query: ( " + selectQuery + " )");

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if(c.moveToFirst()){
            do{
                Description dc = new Description();
                dc.setDescriptionId(c.getInt(c.getColumnIndex(KEY_ID)));
                dc.setDescription(c.getString(c.getColumnIndex(DESCRIPTION_COLUMN)));
                descriptionsList.add(dc);
            }while(c.moveToNext());
        }
        return descriptionsList;
    }


}