package com.example.smdojt.manilafame.Gallery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.smdojt.manilafame.R;

import java.util.ArrayList;

/**
 * Created by smdojt on 2/7/2017.
 */

public class GalleryActivity extends Fragment {


    public GalleryActivity() {
        // Required empty public constructor
    }

    GalleryAdapter mAdapter;
    RecyclerView mRecyclerView;

    ArrayList<ImageModel> data = new ArrayList<>();

    public static String IMGS[] = {
            "http://www.manilafame.com/website-assets/img/media/photos/2016/october/opening-ceremony//06.jpg",
            "http://www.manilafame.com/website-assets/img/media/photos/2016/october/opening-ceremony//05.jpg",
            "http://www.manilafame.com/website-assets/img/media/photos/2016/october/opening-ceremony//04.jpg",
            "http://www.manilafame.com/website-assets/img/media/photos/2016/october/opening-ceremony//03.jpg",
            "http://www.manilafame.com/website-assets/img/media/photos/2016/october/opening-ceremony//02.jpg",
            "http://www.manilafame.com/website-assets/img/media/photos/2016/october/opening-ceremony//01.jpg",
            "http://www.manilafame.com/website-assets/img/media/photos/2016/october/katha-awards//10.jpg",
            "http://www.manilafame.com/website-assets/img/media/photos/2016/october/katha-awards//09.jpg"
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Gallery");
        View v = inflater.inflate(R.layout.gallery_activity, container, false);


        for (int i = 0; i < IMGS.length; i++) {

            ImageModel imageModel = new ImageModel();
            imageModel.setName("Spring Forward Photo " + i);
            imageModel.setUrl(IMGS[i]);
            data.add(imageModel);

        }

        //Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        //((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        //Removing the comment for code above will set the Tab.setTitle to "GALLERY" on all fragment.

        mRecyclerView = (RecyclerView) v.findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mRecyclerView.setHasFixedSize(true);


        mAdapter = new GalleryAdapter(getActivity(), data);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {

                        Intent intent = new Intent(getActivity(), DetailActivity.class);
                        intent.putParcelableArrayListExtra("data", data);
                        intent.putExtra("pos", position);
                        startActivity(intent);

                    }
                }));

        return v;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // this takes the user 'back', as if they pressed the left-facing triangle icon on the main android toolbar.
                // if this doesn't work as desired, another possibility is to call `finish()` here.
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}