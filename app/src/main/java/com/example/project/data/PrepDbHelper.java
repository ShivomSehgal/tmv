package com.example.project.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class PrepDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = PrepDbHelper.class.getSimpleName();

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "interviewprep.db";

    //sqlite3 interviewPrep.db

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link PrepDbHelper}.
     *
     * @param context of the app
     */
    public PrepDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PrepTime.PrepEntry.TABLE_NAME + " ("
                + PrepTime.PrepEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PrepTime.PrepEntry.COLUMN_PROBLEM_SOLVING + " TEXT NOT NULL, "
                + PrepTime.PrepEntry.COLUMN_PROJECT + " TEXT, "
                + PrepTime.PrepEntry.COLUMN_DATE + " INTEGER NOT NULL, "
                + PrepTime.PrepEntry.COLUMN_TASK + " INTEGER NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
