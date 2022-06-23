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



//        import android.app.Activity;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.ArrayAdapter;
//        import android.widget.ImageView;
//        import android.widget.TextView;
//
//        import androidx.annotation.NonNull;
//        import androidx.annotation.Nullable;
//
//        import java.util.ArrayList;

public class DsaAdapter extends ArrayAdapter<DsaSubclass> {

    private static final String LOG_TAG = DsaAdapter.class.getSimpleName();

    public DsaAdapter(Activity context, ArrayList<DsaSubclass> grades){
        super(context, 0, grades);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView1 = convertView;
        if (listItemView1 == null) {
            listItemView1 = LayoutInflater.from(getContext()).inflate(
                    R.layout.dsa_layout, parent, false
            );
        }

        DsaSubclass currentName = getItem(position);
        TextView topicTextView = (TextView) listItemView1.findViewById(R.id.topic);
        topicTextView.setText(currentName.getDsaTopic());

        TextView subTopic1TextView = (TextView) listItemView1.findViewById(R.id.sub1);
        subTopic1TextView.setText(currentName.getDsaProfLvl());

        TextView subTopic2TextView = (TextView) listItemView1.findViewById(R.id.sub2);
        subTopic2TextView.setText(currentName.getDsaQuesRatio());

        TextView subTopic3TextView = (TextView) listItemView1.findViewById(R.id.sub);
        subTopic3TextView.setText(currentName.getDsaSub());


        return listItemView1;
    }

}
