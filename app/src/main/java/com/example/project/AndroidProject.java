package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

//public class AndroidProject extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_android_project);
//    }
//}
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AndroidProject extends AppCompatActivity {
    private static final long startTime = MainActivity2.timeSelectedForPreparation;

    private double timeLeft = startTime*.35;

    CountDownTimer mCountDownTimer;


    Button enigmaButton;
    ImageView userInterface, userInput, multiscreenApps, networking, dataStorage, advanceAndroidDevelopment,
    developingAndroidApps, FirebaseInWeekend, MaterialDesign;

    //    TextView textView;
//    CheckBox checkBox;
//    Button button;
//    static int value = 0;
    ListView listView;
    ArrayAdapter<String> adapter;
    String[] strArray = {"Android Basics : User Interface",
            "Android Basics : User Input",
            "Android Basics : Multiscreen Apps",
            "Android Basics : Networking",
            "Android Basics : Data Storage",
            "Developing Android Apps",
            "Advanced Android development",
            "Firebase in a weekend",
            "Material Design",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_project);

        mCountDownTimer = new CountDownTimer((long)timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(AndroidProject.this, HomeScreen.class));
                Toast.makeText(AndroidProject.this, "Android Project Daily Limit reached", Toast.LENGTH_SHORT).show();
            }
        }.start();

//        Intent intent = new Intent(this, androidProjectResult.class);
//
////        textView = findViewById(R.id.textViewAp);
////        checkBox = findViewById(R.id.checkBoxAp);
////        button = findViewById(R.id.buttonAp);
//
//        ArrayList<ApSubclass> array = new ArrayList<ApSubclass>();
//        array.add(new ApSubclass());
//        array.add(new ApSubclass());
//        array.add(new ApSubclass());
//        array.add(new ApSubclass());
//        array.add(new ApSubclass());
//        array.add(new ApSubclass());
//        array.add(new ApSubclass());
//        array.add(new ApSubclass());
//        array.add(new ApSubclass());
//        array.add(new ApSubclass("User Interface", true));
//        array.add(new ApSubclass("User Interface", true));

//        ApAdapter namer = new ApAdapter(this, array);

        userInput = findViewById(R.id.userInput);


        enigmaButton = findViewById(R.id.enigmaButtonForIntent);
        enigmaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AndroidProject.this, Enigma.class));
            }
        });


        listView = (ListView) findViewById(R.id.androidList);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strArray);

        listView.setAdapter(adapter);

    }
    public void openBrowser(View view){

        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

//        int value = 0;

//        for (int idx = 0; idx < array.size(); idx++) {
//            checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(checkBox.isChecked()) value++;
//            }
//        });
//        }



//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (value == 0) {
//                    Toast.makeText(AndroidProject.this, "Make Selections to get Report", Toast.LENGTH_SHORT).show();
//                } else {
//                    startActivity(intent);
//                    Toast.makeText(AndroidProject.this, "Getting Statistical Report", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });






//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
////        return super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.main_menu,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if(id == R.id.item_done){
//            String itemSelected = "Completed Courses \n ";
//            for (int idx = 0; idx < listView.getCount(); idx++) {
//                if(listView.isItemChecked(idx)) {
//                    itemSelected += listView.getItemAtPosition(idx) + "\n";
//                }
//            }
//            Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
//        }
//
//        return super.onOptionsItemSelected(item);
//    }



//    private void onCheckboxClicked(View view) {
//        // Is the view now checked?
//        boolean checked = ((CheckBox) view).isChecked();
//        switch (view.getId()) {
//            case R.id.checkBoxAp:
//                if (checked)
//                    value++;
//                break;
//        }
//    }
}