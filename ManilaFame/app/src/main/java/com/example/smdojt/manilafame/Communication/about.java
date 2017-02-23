package com.example.smdojt.manilafame.Communication;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.smdojt.manilafame.R;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        this.setTitle("About Us? Naging tayo ba?");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        TextView txt1 = (TextView) findViewById(R.id.textView1);
        TextView txt2 = (TextView) findViewById(R.id.textView2);
        TextView txt3 = (TextView) findViewById(R.id.textView3);
        Typeface font = Typeface.createFromAsset(this.getAssets(), "century_gothic_bold.ttf");
        Typeface font1 = Typeface.createFromAsset(this.getAssets(), "century_gothic_regular.ttf");
        txt1.setTypeface(font);
        txt2.setTypeface(font1);
        txt3.setTypeface(font1);
    }
}
