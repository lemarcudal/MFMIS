package com.example.smdojt.manilafame.Buyer_Registration;

import android.app.ProgressDialog;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.smdojt.manilafame.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Buyer_Registration_Activity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextCompanyName, editTextDate, editTextLastName, editTextFirstName, editTextMiddleInitial
            , editTextCity;
    private RadioButton tradebuyer, nontradebuyer;
    private Spinner spinnerCountry;
    private Button buttonRegister;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_registration);

        this.setTitle("Buyer Registration");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        editTextCompanyName = (EditText) findViewById(R.id.editTextEmail);
        editTextDate = (EditText) findViewById(R.id.editTextUsername);
        editTextLastName = (EditText) findViewById(R.id.editTextPassword);
        editTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        editTextMiddleInitial = (EditText) findViewById(R.id.editTextMiddleInitial);
        editTextCity = (EditText) findViewById(R.id.editTextCity);
        tradebuyer = (RadioButton) findViewById(R.id.rButtonTrade);
        nontradebuyer = (RadioButton) findViewById(R.id.rButtonNonTrade);
        spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        progressDialog = new ProgressDialog(this);
        buttonRegister.setOnClickListener(this);

    }

    private void registerUser(){
        final String cname = editTextCompanyName.getText().toString().trim();
        final String date = editTextDate.getText().toString().trim();
        final String lname = editTextLastName.getText().toString().trim();
        final String fname = editTextFirstName.getText().toString().trim();
        final String mi = editTextMiddleInitial.getText().toString().trim();
        final String city = editTextCity.getText().toString().trim();

        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                com.example.smdojt.manilafame.sql_demo_2.Constants.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {//If there are no ERROR this method will be executed
                        progressDialog.dismiss();
                        //we will get the json object
                        try {
                            JSONObject jsonObject = new JSONObject(response);  //create json object
                            Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) { // Else, this method will be executed
                        progressDialog.hide();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError { //put all parameters that will be sent to hash map
                Map<String, String> params = new HashMap<>();
                params.put("cname", cname); //String is converted to final, because we'are using it in a class; refer to line 48-50
                params.put("date", date);
                params.put("lname", lname);
                params.put("fname", fname);
                params.put("mi", mi);
                params.put("city", city);
                return params;
            }
        };

        //add stringRequest (Line 55)
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View view) {
        if (view==buttonRegister)
        {
            registerUser();
        }
    }
}
