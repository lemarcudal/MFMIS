package com.example.smdojt.manilafame;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.smdojt.manilafame.Buyer_Registration.Buyer_Registration_Activity;
import com.example.smdojt.manilafame.Exhibitor_Registration.Exhibitor_Registration_Activity;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment{

    Button forExhibitors, forBuyers, forPress;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Home");
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        TextView title1 = (TextView) v.findViewById(R.id.title1);
        TextView title2 = (TextView) v.findViewById(R.id.title2);
        TextView txt1 = (TextView) v.findViewById(R.id.about_p1);
        TextView txt2 = (TextView) v.findViewById(R.id.about_p2);
        TextView txt3 = (TextView) v.findViewById(R.id.new_ed);
        forExhibitors = (Button) v.findViewById(R.id.forExhibitors);
        forBuyers = (Button) v.findViewById(R.id.forExhibitors);
        forPress = (Button) v.findViewById(R.id.forPress);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "century_gothic_bold.ttf");
        Typeface font1 = Typeface.createFromAsset(getActivity().getAssets(), "century_gothic_regular.ttf");
        txt1.setTypeface(font1);
        txt2.setTypeface(font1);
        txt3.setTypeface(font1);
        title1.setTypeface(font);
        title2.setTypeface(font);


        v.findViewById(R.id.forExhibitors).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),Exhibitor_Registration_Activity.class);
                startActivity(i);
            }
        });

        v.findViewById(R.id.forBuyers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),Buyer_Registration_Activity.class);
                startActivity(i);
            }
        });
        return v;
    }

}
