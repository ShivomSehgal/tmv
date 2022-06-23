package com.example.project;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class sqlAdapter extends ArrayAdapter<sqlSubclass> {

    private static final String LOG_TAG = sqlAdapter.class.getSimpleName();

    public sqlAdapter(Activity context, ArrayList<sqlSubclass> grades){
        super(context, 0, grades);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView1 = convertView;
        if (listItemView1 == null) {
            listItemView1 = LayoutInflater.from(getContext()).inflate(
                    R.layout.relational_database_sublayout, parent, false
            );
        }

        sqlSubclass currentQuery = getItem(position);
        TextView topicTextView = (TextView) listItemView1.findViewById(R.id.relationalQuery);
        topicTextView.setText(currentQuery.getQuery());

//        sqlSubclass currentSol = getItem(position);
        TextView topicTextView2 = (TextView) listItemView1.findViewById(R.id.relationalSol);
        topicTextView2.setText(currentQuery.getAnswer());


        return listItemView1;
    }

}
