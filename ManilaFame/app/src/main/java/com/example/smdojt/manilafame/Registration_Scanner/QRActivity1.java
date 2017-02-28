package com.example.smdojt.manilafame.Registration_Scanner;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;

import com.example.smdojt.manilafame.R;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;;

public class QRActivity1 extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_activity1);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

    }

    public void QrScanner(View view){


        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);

        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();         // Start camera

    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here


        Log.e("handler", rawResult.getText()); // Prints scan results
        Log.e("handler", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)

        String myUrl = rawResult.getText();

        // show the scanner result into dialog box.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(rawResult.getText());
        AlertDialog alert1 = builder.create();
        //
        alert1.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // You don't have to do anything here if you just want it dismissed when clicked
            }
        });
        //
        alert1.show();
        //if the pattern == website url regex, then transfer
        if (Patterns.WEB_URL.matcher(myUrl).matches()) {
            Intent visitUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(myUrl));
            startActivity(visitUrl);
            mScannerView.stopCamera();
            setContentView(R.layout.qr_activity1);
        }



        // If you would like to resume scanning, call this method below:
        //mScannerView.resumeCameraPreview(this);
    }
}
