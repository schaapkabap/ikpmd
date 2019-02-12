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



public class apikey extends AppCompatActivity {

    EditText editText2;
    Button apikey;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String APIkey = "nameKey";


    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apikey);

        editText2=(EditText)findViewById(R.id.editText2);

        apikey=(Button)findViewById(R.id.APIkeybutton);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        apikey.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String api  = editText2.getText().toString();


                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(APIkey, api);

                editor.apply();
                Toast.makeText(apikey.this,"dank u wel voor de key",Toast.LENGTH_LONG).show();
            }
        });
    }
}
