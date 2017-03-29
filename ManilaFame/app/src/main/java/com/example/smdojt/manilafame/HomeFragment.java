package com.example.smdojt.manilafame;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Home");
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        TextView txt1 = (TextView) v.findViewById(R.id.about_p1);
        TextView txt2 = (TextView) v.findViewById(R.id.about_p2);
        TextView txt3 = (TextView) v.findViewById(R.id.new_ed);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "century_gothic_bold.ttf");
        Typeface font1 = Typeface.createFromAsset(getActivity().getAssets(), "century_gothic_regular.ttf");
        txt1.setTypeface(font1);
        txt2.setTypeface(font1);
        txt3.setTypeface(font1);

        return v;
    }

}
