package com.example.smdojt.manilafame.Exhibitor.Exhibitor_Local;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smdojt.manilafame.R;

public class TabLoc_CV_Activity extends AppCompatActivity {

    TextView itemName;
    TextView itemCathegory;
    ImageView itemPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_exhibitor_tabloc_cv_activity);

        itemName = (TextView)findViewById(R.id.item_name);
        itemCathegory = (TextView) findViewById(R.id.item_cathegory);
        itemPhoto = (ImageView) findViewById(R.id.item_photo);

        itemName.setText("CITEM");
        itemCathegory.setText("Manila Fame");
        itemPhoto.setImageResource(R.drawable.emma);
    }
}
