package com.example.smdojt.manilafame.Communication;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.smdojt.manilafame.R;

public class contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        this.setTitle("Contact Us");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        TextView txt1 = (TextView) findViewById(R.id.textView1);
        TextView txt2 = (TextView) findViewById(R.id.textView2);
        TextView txt3 = (TextView) findViewById(R.id.textView3);
        TextView txt4 = (TextView) findViewById(R.id.textView4);
        TextView txt5 = (TextView) findViewById(R.id.textView5);
        TextView txt6 = (TextView) findViewById(R.id.textView6);
        Typeface font1 = Typeface.createFromAsset(this.getAssets(), "century_gothic_bold.ttf");
        Typeface font2 = Typeface.createFromAsset(this.getAssets(), "century_gothic_regular.ttf");
        txt1.setTypeface(font1);
        txt2.setTypeface(font2);
        txt3.setTypeface(font1);
        txt4.setTypeface(font2);
        txt5.setTypeface(font1);
        txt6.setTypeface(font2);
    }
}
