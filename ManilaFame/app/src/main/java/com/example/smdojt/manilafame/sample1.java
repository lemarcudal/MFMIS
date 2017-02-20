package com.example.smdojt.manilafame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class sample1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample1);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }
}
