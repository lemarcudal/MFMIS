package com.example.smdojt.manilafame.Attendees;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.smdojt.manilafame.Communication.about;
import com.example.smdojt.manilafame.Communication.contact;
import com.example.smdojt.manilafame.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabAttendeesVIPFragment extends Fragment {


    public TabAttendeesVIPFragment() {
        // Required empty public constructor
    }

    ListView list;
    String[] VipAttendees = {
            "Google Plus",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal"
    };

    int[] imageID = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7
    };


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_attendees_vip_tab, container, false);
        CustomListVip adapter = new
                CustomListVip(TabAttendeesVIPFragment.this.getActivity(), VipAttendees, imageID);
        list = (ListView) v.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Intent intent = new Intent(getActivity(), about.class);
                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(getActivity(), contact.class);
                    startActivity(intent);
                }
            }
        });
        return v;
    }

}
