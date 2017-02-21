package com.example.smdojt.manilafame.ListGalleries;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.smdojt.manilafame.Gallery.GalleryActivity;
import com.example.smdojt.manilafame.R;

public class ListGalleryFragment extends Fragment {

    public ListGalleryFragment() {
        // Required empty public constructor
    }

    ListView list;
    String[] AllGalleries = {
            "Spring Forward",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal"
    };
    String[] AllGalleriesSub = {
            "Manila Fame",
            "Citem 1",
            "Citem 2",
            "Citem 3",
            "Citem 4",
            "Citem 5",
            "Citem 6"
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("MANILA FAME GALLERIES");
        View v = inflater.inflate(R.layout.fragment_list_gallery, container, false);

        CustomList adapter = new
                CustomList(ListGalleryFragment.this.getActivity(), AllGalleries, AllGalleriesSub, imageID);
        list = (ListView) v.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    GalleryActivity fr = new GalleryActivity();
                    Bundle args = new Bundle();
                    fr.setArguments(args);
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fr);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                if (position == 1) {

                }
            }
        });
        return v;
    }



}