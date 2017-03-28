package com.example.smdojt.manilafame.Exhibitor_Registration;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.smdojt.manilafame.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class Exhibitor_Registration_Activity extends AppCompatActivity  {

    Button buttonDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibitor_registration_);

        this.setTitle("Buyer Registration");

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        final Button buttonDownload = (Button) findViewById(R.id.buttonDownload);
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

        buttonDownload.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String url = "http://www.manilafame.com/website-assets/downloads/exhibitor-application-kit/local/201704/1-Summary-of-Participation-Details-April-2017_MN_002.pdf";
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                request.setDescription("Some descrition");
                request.setTitle("Some title");
// in order for this if to run, you must use the android 3.2 to compile your app
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                }
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "name-of-the-file.ext");

// get download service and enqueue file
                DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
            }
        });
    }

    public static boolean isDownloadManagerAvailable(Context context) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            return true;
        }
        return false;
    }
}
