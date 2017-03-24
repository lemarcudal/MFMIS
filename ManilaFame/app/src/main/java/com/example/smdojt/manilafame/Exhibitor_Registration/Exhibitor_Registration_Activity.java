package com.example.smdojt.manilafame.Exhibitor_Registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.smdojt.manilafame.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exhibitor_Registration_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibitor_registration_);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

//        URL u = new URL("http://www.path.to/a.mp4?video");
//        HttpURLConnection c = (HttpURLConnection) u.openConnection();
//        c.setRequestMethod("GET");
//        c.setDoOutput(true);
//        c.connect();
//        FileOutputStream f = new FileOutputStream(new File(root,"Video.mp4"));
//
//
//        InputStream in = c.getInputStream();
//
//        byte[] buffer = new byte[1024];
//        int len1 = 0;
//        while ( (len1 = in.read(buffer)) > 0 ) {
//            f.write(buffer);
//        }
//        f.close();

    }
}
