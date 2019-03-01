package com.example.schaapkabap.biercollection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.schaapkabap.biercollection.activitys.ApikeyActivity;
import com.example.schaapkabap.biercollection.activitys.DataLink;
import com.example.schaapkabap.biercollection.activitys.RecensieActivity;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements DataLink, Serializable {

    private Button Bierlist;
    private Button Firebase;
    private Button Grafieken;
    private Button Apikey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elementLinker();

        Apikey.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Apikey ingedrukt", "start ApikeyActivity");
                startActivity(new Intent(MainActivity.this, ApikeyActivity.class));
            }
        });

        Bierlist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Bierbutton ingedrukt", "start Bierlist");
                startActivity(new Intent(MainActivity.this, com.example.schaapkabap.biercollection.activitys.ItemListActivity.class));
            }
        });

        Firebase.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Firebasebutton ingedrukt", "start RecensieActivity");
                startActivity(new Intent(MainActivity.this, RecensieActivity.class));
            }
        });

        Grafieken.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Grafiekenbutton ingedrukt", "start GrafiekenActivity");
                startActivity(new Intent(MainActivity.this, com.example.schaapkabap.biercollection.activitys.Baractivity.class));
            }
        });
    }

    @Override
    public void elementLinker() {
        Bierlist = (Button) findViewById(R.id.Listbutton);
        Firebase = (Button) findViewById(R.id.Firebasebutton);
        Grafieken = (Button) findViewById(R.id.Grafiekbutton);
        Apikey  = (Button) findViewById(R.id.Apikey);
    }
}
