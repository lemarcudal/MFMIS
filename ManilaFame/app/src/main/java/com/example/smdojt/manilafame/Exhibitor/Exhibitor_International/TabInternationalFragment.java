package com.example.smdojt.manilafame.Exhibitor.Exhibitor_International;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smdojt.manilafame.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabInternationalFragment extends Fragment {

    private List<Exhibitors_Int> items;
    private RecyclerView rv;

    public TabInternationalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab_international, container, false);

        rv = (RecyclerView) v.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        initializeData();
        initializeAdapter();
        return v;
    }

    private void initializeData()
    {
        items = new ArrayList<>();
        items.add(new Exhibitors_Int("A. GARCIA CRAFTS", "FURNITURE", R.drawable.image1));
        items.add(new Exhibitors_Int("BALEX BOXES", "HOLIDAY DECORATION", R.drawable.image2));
        items.add(new Exhibitors_Int("CAGAYAN DE ORO HANDMADE PAPER", "HOME DECOR/HOUSEWARE", R.drawable.image3));
        items.add(new Exhibitors_Int("CV. BALI BAKTI ANGGARA", "FOREIGN", R.drawable.image1));
        items.add(new Exhibitors_Int("CV. WITA HARA KIRANA", "FOREIGN", R.drawable.image1));
        items.add(new Exhibitors_Int("LIA AFIF", "FOREIGN", R.drawable.image1));
        items.add(new Exhibitors_Int("NAPUTO BALI", "FOREIGN", R.drawable.image1));
    }

    private void initializeAdapter()
    {
        TabInt_RV_Adapter adapter = new TabInt_RV_Adapter(items, getContext());
        rv.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        initializeData();
        initializeAdapter();
        super.onResume();
    }
}
