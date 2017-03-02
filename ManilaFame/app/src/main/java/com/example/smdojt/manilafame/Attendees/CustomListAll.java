package com.example.smdojt.manilafame.Attendees;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smdojt.manilafame.R;

public class CustomListAll extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] AllAttendees;
    private final int[] imageId;
    public CustomListAll(Activity context,
                         String[] AllAttendess, int[] imageId) {
        super(context, R.layout.fragment_attendees_custom_list_all, AllAttendess);
        this.context = context;
        this.AllAttendees = AllAttendess;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.fragment_attendees_custom_list_all, null, true);
        TextView txtName = (TextView) rowView.findViewById(R.id.txtName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtName.setText(AllAttendees[position]);
        imageView.setImageResource(Integer.parseInt(String.valueOf(imageId[position])));
        return rowView;
    }
}