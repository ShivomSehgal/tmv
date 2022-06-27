package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.project.data.PrepDbHelper;
import com.example.project.data.PrepTime;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.os.Bundle;

public class InterviewPrep extends AppCompatActivity {

    private PrepDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_prep);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InterviewPrep.this, InterviewPrepEditor.class));
            }
        });
        mDbHelper = new PrepDbHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }
    private void displayDatabaseInfo(){

        SQLiteDatabase sb = mDbHelper.getReadableDatabase();

        String[] projection = {
                PrepTime.PrepEntry._ID,
                PrepTime.PrepEntry.COLUMN_PROBLEM_SOLVING,
                PrepTime.PrepEntry.COLUMN_PROJECT,
                PrepTime.PrepEntry.COLUMN_TASK,
                PrepTime.PrepEntry.COLUMN_DATE
        };

        Cursor cursor = sb.query(
                PrepTime.PrepEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        TextView displayView = (TextView) findViewById(R.id.text_view_prep);
        try {
            displayView.setText("The Prep table contains " + cursor.getCount()+ "prep days");

            displayView.append(PrepTime.PrepEntry._ID + " - " +
                    PrepTime.PrepEntry.COLUMN_PROBLEM_SOLVING + " - " +
                    PrepTime.PrepEntry.COLUMN_PROJECT + " - " +
                    PrepTime.PrepEntry.COLUMN_TASK+ " - " +
                    PrepTime.PrepEntry.COLUMN_DATE + " \n ");

            int idColumnIndex = cursor.getColumnIndex(PrepTime.PrepEntry._ID);
            int problemSolvingColumnIndex = cursor.getColumnIndex(PrepTime.PrepEntry.COLUMN_PROBLEM_SOLVING);
            int projectColumnIndex = cursor.getColumnIndex(PrepTime.PrepEntry.COLUMN_PROJECT);
            int taskColumnIndex = cursor.getColumnIndex(PrepTime.PrepEntry.COLUMN_TASK);
            int dateColumnIndex = cursor.getColumnIndex(PrepTime.PrepEntry.COLUMN_DATE);

            while(cursor.moveToNext()){
                int currentID = cursor.getInt(idColumnIndex);
                String currentProblemSolving = cursor.getString(problemSolvingColumnIndex);
                String currentProject = cursor.getString(projectColumnIndex);
                int currentTask = cursor.getInt(taskColumnIndex);
                int currentDate = cursor.getInt(dateColumnIndex);

                displayView.append(("\n" + currentID + " - " +
                        currentProblemSolving + " - " +
                        currentProject + " - " +
                        currentTask + " - " +
                        currentDate));
            }
        }finally {
            cursor.close();
        }

    }

    private void insertPet(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PrepTime.PrepEntry.COLUMN_PROBLEM_SOLVING, "Binary Tree");
        values.put(PrepTime.PrepEntry.COLUMN_PROJECT, "Firebase Authentication");
        values.put(PrepTime.PrepEntry.COLUMN_TASK, PrepTime.PrepEntry.TASK_NOT_DONE);
        values.put(PrepTime.PrepEntry.COLUMN_DATE, 12022022);

        long newRowId = db.insert(PrepTime.PrepEntry.TABLE_NAME, null, values);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_ip, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_insert_dummy_data:
                insertPet();
                displayDatabaseInfo();
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_entries:
                // Do nothing for now
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}