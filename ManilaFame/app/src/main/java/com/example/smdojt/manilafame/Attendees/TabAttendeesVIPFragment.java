package com.example.smdojt.manilafame.Attendees;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smdojt.manilafame.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabAttendeesVIPFragment extends Fragment {


    public TabAttendeesVIPFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attendees_vip_tab, container, false);
    }

}
