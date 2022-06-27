package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.project.data.PrepDbHelper;
import com.example.project.data.PrepTime;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import android.os.Bundle;
import android.widget.Toast;

public class InterviewPrepEditor extends AppCompatActivity {

    private EditText mNameEditText;

    /** EditText field to enter the pet's breed */
    private EditText mProjectEditText;

    /** EditText field to enter the pet's weight */
    private EditText mDateEditText;

    /** EditText field to enter the pet's gender */
    private Spinner mTaskSpinner;

    private PrepDbHelper mDbHelper;

    private int mGender = PrepTime.PrepEntry.TASK_NOT_DONE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_prep_editor);

        mNameEditText = (EditText) findViewById(R.id.edit_prep_dsa);
        mProjectEditText = (EditText) findViewById(R.id.edit_prep_project);
        mDateEditText = (EditText) findViewById(R.id.edit_prep_date);
        mTaskSpinner = (Spinner) findViewById(R.id.spinner_task);

        setupSpinner();


    }

    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_task_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mTaskSpinner.setAdapter(genderSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mTaskSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.task_incomplete))) {
                        mGender = PrepTime.PrepEntry.TASK_INCOMPLETE;
                    } else if (selection.equals(getString(R.string.task_complete))) {
                        mGender = PrepTime.PrepEntry.TASK_COMPLETE;
                    } else {
                        mGender = PrepTime.PrepEntry.TASK_NOT_DONE;
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGender = PrepTime.PrepEntry.TASK_NOT_DONE;
            }
        });

    }

    private void insertPrep() {
        // Read from input fields
        // Use trim to eliminate leading or trailing white space
        String nameString = mNameEditText.getText().toString().trim();
        String breedString = mProjectEditText.getText().toString().trim();
        String weightString = mDateEditText.getText().toString().trim();
        int weight = Integer.parseInt(weightString);

        // Create database helper
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PrepTime.PrepEntry.COLUMN_PROBLEM_SOLVING, "Binary Tree");
        values.put(PrepTime.PrepEntry.COLUMN_PROJECT, "Firebase Authentication");
        values.put(PrepTime.PrepEntry.COLUMN_TASK, PrepTime.PrepEntry.TASK_NOT_DONE);
        values.put(PrepTime.PrepEntry.COLUMN_DATE, 12022022);

        long newRowId = db.insert(PrepTime.PrepEntry.TABLE_NAME, null, values);

        if (newRowId == -1) {
            Toast.makeText(this, "Error with saving pet", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Pet saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_ip_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                // Save pet to database
                insertPrep();
                // Exit activity
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}