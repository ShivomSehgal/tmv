package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    Button dsaButton, androidProjectButton, performanceButton, dataAnalysisButton,
            applicationsButton, coreFundamentalButton, interviewPrepButton, dailyTestButton,
            sqlButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        dsaButton = findViewById(R.id.dsa);
        androidProjectButton = findViewById(R.id.project);
        applicationsButton = findViewById(R.id.applications);
        coreFundamentalButton = findViewById(R.id.coreFundamentals);
        interviewPrepButton = findViewById(R.id.interviewPrep);
        dailyTestButton = findViewById(R.id.dailyTest);
        sqlButton = findViewById(R.id.sqlButton);
        dataAnalysisButton = findViewById(R.id.dataAnalysisVisualization);


        sqlButton.setBackgroundResource(000000);
        dataAnalysisButton.setBackgroundResource(000000);
        dsaButton.setBackgroundResource(000000);
        androidProjectButton.setBackgroundResource(000000);
        applicationsButton.setBackgroundResource(000000);
        coreFundamentalButton.setBackgroundResource(000000);
        interviewPrepButton.setBackgroundResource(000000);
        dailyTestButton.setBackgroundResource(000000);

        dsaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this,DataStructures.class));
            }
        });

        androidProjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, AndroidProject.class));
            }
        });

        interviewPrepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, InterviewPrep.class));
            }
        });

        coreFundamentalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, CoreFundamentals.class));
            }
        });

        applicationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this,DoubtActivity.class));
            }
        });

        dailyTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, DailyTestQuestions.class));
            }
        });
//
        sqlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this, RelationalDatabase.class));
            }
        });

        dataAnalysisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, DataAnalysisAndVisualisation.class));
            }
        });
    }
}