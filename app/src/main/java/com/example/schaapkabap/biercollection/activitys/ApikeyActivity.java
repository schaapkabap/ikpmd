package com.example.schaapkabap.biercollection.activitys;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.schaapkabap.biercollection.R;
import com.example.schaapkabap.biercollection.helpers.SharePref;


public class ApikeyActivity extends AppCompatActivity implements DataLink{

    EditText editText2;
    Button apikey;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String APIkey = "Apikey";


    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apikey);
        elementLinker();


        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        editText2.setText(SharePref.getInstance(getApplicationContext()).getPlaceObj());

        apikey.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String api  = editText2.getText().toString();
                if(api == ""){
                    Toast.makeText(ApikeyActivity.this, "Vul een key in!",Toast.LENGTH_SHORT).show();
                }
                SharePref.getInstance(getApplicationContext()).savePlaceObj(api);
                Toast.makeText(ApikeyActivity.this,"De key is opgeslagen",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    @Override
    public void elementLinker() {
        editText2=(EditText)findViewById(R.id.editText2);

        apikey=(Button)findViewById(R.id.APIkeybutton);
    }
}
