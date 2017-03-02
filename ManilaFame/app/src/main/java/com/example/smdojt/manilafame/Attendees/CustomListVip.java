package com.example.smdojt.manilafame.Attendees;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import com.example.smdojt.manilafame.R;

public class CustomListVip extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] VipAttendees;
    private final int[] imageId;
    public CustomListVip(Activity context,
                      String[] VipAttendees, int[] imageId) {
        super(context, R.layout.fragment_attendees_custom_list_vip, VipAttendees);
        this.context = context;
        this.VipAttendees = VipAttendees;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.fragment_attendees_custom_list_vip, null, true);
        TextView txtName = (TextView) rowView.findViewById(R.id.txtName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtName.setText(VipAttendees[position]);
        imageView.setImageResource(Integer.parseInt(String.valueOf(imageId[position])));
        return rowView;
    }
}
