package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RelationalDatabase extends AppCompatActivity {

    private static final long startTime = MainActivity2.timeSelectedForPreparation;

    private double timeLeft = startTime*.05;

    CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relational_database);

        mCountDownTimer = new CountDownTimer((long)timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(RelationalDatabase.this, HomeScreen.class));
                Toast.makeText(RelationalDatabase.this, "Relational Database Daily Limit reached", Toast.LENGTH_SHORT).show();
            }
        }.start();

        ArrayList<sqlSubclass> sqlList = new ArrayList<sqlSubclass>();


        sqlList.add(new sqlSubclass("Q1. Write a query to fetch the EmpFname from the EmployeeInfo table in upper case and use the ALIAS name as EmpName.","SELECT UPPER(EmpFname) AS EmpName\n FROM EmployeeInfo;"));
        sqlList.add(new sqlSubclass("Q2. Write a query to fetch the number of employees working in the department ‘HR’.","SELECT COUNT(*)  FROM EmployeeInfo\n WHERE Department = 'HR';"));
        sqlList.add(new sqlSubclass("Q3. Write a query to get the current date.","SELECT GETDATE();"));
        sqlList.add(new sqlSubclass("Q4. Write a query to retrieve the first four characters of  EmpLname from the EmployeeInfo table.","SELECT SUBSTRING(EmpLname, 1, 4) \nFROM EmployeeInfo;"));
        sqlList.add(new sqlSubclass("Q5. Write a query to fetch only the place name(string before brackets) from the Address column of EmployeeInfo table.","SELECT SUBSTRING(Address, 1, CHARINDEX('(',Address)) \nFROM EmployeeInfo;"));
        sqlList.add(new sqlSubclass("Q6. Write a query to create a new table which consists of data and structure copied from the other table.","SELECT * INTO NewTable \nFROM EmployeeInfo\n WHERE 1 = 0;\n"));
        sqlList.add(new sqlSubclass("Q7. Write q query to find all the employees whose salary is between 50000 to 100000.","SELECT * FROM EMPLOYEEPOSITION \nWHERE SALARY \nBETWEEN 50000 AND 100000"));
        sqlList.add(new sqlSubclass("Q8. Write a query to find the names of employees that begin with ‘S’","SELECT * FROM EmployeeInfo WHERE EmpFname LIKE 'S%';"));
        sqlList.add(new sqlSubclass("Q9. Write a query to fetch top N records.","SELECT TOP N *\n FROM EmployeePosition \nORDER BY Salary DESC;"));
        sqlList.add(new sqlSubclass("Q10. Write a query to retrieve the EmpFname and EmpLname in a single column as “FullName”. The first name and the last name must be separated with space.","SELECT CONCAT(EmpFname, ' ', EmpLname) \nAS 'FullName' \nFROM EmployeeInfo;"));
//        sqlList.add(new sqlSubclass("",""));
//        sqlList.add(new sqlSubclass("",""));
//        sqlList.add(new sqlSubclass("",""));
//        sqlList.add(new sqlSubclass("",""));
//        sqlList.add(new sqlSubclass("",""));
//        sqlList.add(new sqlSubclass("",""));
//        sqlList.add(new sqlSubclass("",""));
//
//        sqlList.add(new sqlSubclass("",""));
//        sqlList.add(new sqlSubclass("",""));
//        sqlList.add(new sqlSubclass("",""));
//        sqlList.add(new sqlSubclass("",""));
//        sqlList.add(new sqlSubclass("",""));
//        sqlList.add(new sqlSubclass("",""));
//        sqlList.add(new sqlSubclass("",""));









        ListView listView = (ListView) findViewById(R.id.liste);

        sqlAdapter customAdapter = new sqlAdapter(this, sqlList);
        listView.setAdapter(customAdapter);
    }
}// create subclass and custom array adater