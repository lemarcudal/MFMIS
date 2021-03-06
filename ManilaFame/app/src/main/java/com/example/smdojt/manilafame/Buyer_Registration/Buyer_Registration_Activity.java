package com.example.smdojt.manilafame.Buyer_Registration;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

import java.util.HashMap;
import java.util.Map;

public class Buyer_Registration_Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    private EditText editTextCompanyName, editTextDate, editTextLastName, editTextFirstName, editTextMiddleInitial
            , editTextCity, editTextEmail;
    private Button buttonRegister;
    private ProgressDialog progressDialog;
    private Spinner spinnerCountry;
    String role = "";


    String[] countries={"Afghanistan","Albania","Algeria","Andorra","Angola","Antigua and Barbuda","Argentina","Armenia","Australia",
    "Austria","Azerbaijan"};//Getting the instance of Spinner and applying OnItemSelectedListener on it

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_registration);
        //this.setTitle("Registration");

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);


        editTextCompanyName = (EditText) findViewById(R.id.editTextCompanyName);
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        editTextLastName = (EditText) findViewById(R.id.editTextLastName);
        editTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        editTextMiddleInitial = (EditText) findViewById(R.id.editTextMiddleInitial);
        editTextCity = (EditText) findViewById(R.id.editTextCity);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        progressDialog = new ProgressDialog(this);
        buttonRegister.setOnClickListener(this);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        spinnerCountry.setOnItemSelectedListener(this);
        spinnerCountry.setPrompt("Select Country");
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,R.layout.spinner_style,countries);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the ArrayAdapter data on the Spinner
        spinnerCountry.setAdapter(aa);
    }

    private void registerUser(){
        final String cname = editTextCompanyName.getText().toString().trim();
        final String date = editTextDate.getText().toString().trim();
        final String lname = editTextLastName.getText().toString().trim();
        final String fname = editTextFirstName.getText().toString().trim();
        final String mi = editTextMiddleInitial.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();
        final String city = editTextCity.getText().toString().trim();
        final String country = spinnerCountry.getSelectedItem().toString();
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton r_tb = (RadioButton) findViewById(R.id.radio_tb);
        final RadioButton r_ntb = (RadioButton) findViewById(R.id.radio_ntb);

        if (radioGroup.getCheckedRadioButtonId() == r_tb.getId())
        {
            role = "Trade Buyer";
        }
        else if (radioGroup.getCheckedRadioButtonId() == r_ntb.getId())
        {
            role="Non-Trade Buyer";
        }
        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                com.example.smdojt.manilafame.Buyer_Registration.Constants.URL_REGISTER,
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
                params.put("email", email);
                params.put("city", city);
                params.put("country", country);
                params.put("tbuyer", role); // check code; String created from radio button
                //first parameter represents the variable from mysql, 2nd param. represents the final variable
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

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    // TODO Auto-generated method stub

    }
}
