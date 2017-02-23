package com.example.smdojt.manilafame.ListAttendees;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smdojt.manilafame.R;

public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] AllAttendees;
    private final int[] imageId;
    public CustomList(Activity context,
                      String[] AllAttendess, int[] imageId) {
        super(context, R.layout.fragment_list_attendees_tabs, AllAttendess);
        this.context = context;
        this.AllAttendees = AllAttendess;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.fragment_list_attendees_tabs, null, true);
        TextView txtName = (TextView) rowView.findViewById(R.id.txtName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtName.setText(AllAttendees[position]);
        imageView.setImageResource(Integer.parseInt(String.valueOf(imageId[position])));
        return rowView;
    }
}