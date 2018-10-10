package com.unplugme.model;

import java.util.HashMap;
import java.util.Map;

public class Ergonomics {

    public static final String TABLE_NAME = "ergonomic";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";

    private int id;
    private String title;
    private String description;

    Map<String, String> ergonomicsItmes = new HashMap<>();


    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TITLE + " TEXT, " + COLUMN_DESCRIPTION + " TEXT)";

    public Ergonomics(){

    }


    public Ergonomics(int id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getErgonomicId() {
        return id;
    }

    public void setErgonomicId(int id) {
        this.id = id;
    }

    public String getErgonomicTitle() {
        return title;
    }

    public void setErgonomicTitle(String title) {
        this.title = title;
    }

    public String getErgonomicDescription() {
        return description;
    }

    public void setErgonomicDescription(String description) {
        this.description = description;
    }

//    String sqlstr6 = "INSERT INTO " + ERGONOMICS_TABLE + " (" + TITLE_COLUMN + ", " + DESCRIPTION_COLUMN + ") VALUES " +
//            "('Monitor`s Distance', 'The monitor should be an arm`s length away from you.')," +
//            "('Monitor Height', 'The top of the monitor should be at eye level.')," +
//            "('Lighting', 'Light positioning will depend on desk placement and monitor height, " +
//            "as well as if you are next to a window and how brightly the sun shines in.')";
//        db.execSQL(sqlstr6);

}
