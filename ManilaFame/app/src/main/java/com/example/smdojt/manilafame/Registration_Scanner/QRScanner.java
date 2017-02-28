package com.example.smdojt.manilafame.Registration_Scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.smdojt.manilafame.R;

public class QRScanner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_scanner);

        this.setTitle("QR Scanner");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        findViewById(R.id.btnScan1).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), QRActivity1.class);
                startActivity(i);
            }
        });
    }

}
