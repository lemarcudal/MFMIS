package com.example.smdojt.manilafame.Exhibitor.Exhibitor_International;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smdojt.manilafame.R;

/**
 * Created by smdojt on 2/21/2017.
 */

public class TabInt_CV_Activity extends Activity {

    TextView itemName;
    TextView itemCathegory;
    ImageView itemPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_exhibitor_tabint_cv_activity);
        itemName = (TextView)findViewById(R.id.item_name);
        itemCathegory = (TextView) findViewById(R.id.item_cathegory);
        itemPhoto = (ImageView) findViewById(R.id.item_photo);

        itemName.setText("CITEM");
        itemCathegory.setText("Manila Fame");
        itemPhoto.setImageResource(R.drawable.emma);
    }
}
