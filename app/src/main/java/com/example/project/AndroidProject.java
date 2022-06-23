package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AndroidProject extends AppCompatActivity {


    Button enigmaButton;

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


        enigmaButton = findViewById(R.id.enigmaButtonForIntent);
        enigmaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AndroidProject.this, Enigma.class));
            }
        });


        listView = (ListView) findViewById(R.id.androidList);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, strArray);

        listView.setAdapter(adapter);



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


    }

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