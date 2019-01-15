package com.example.schaapkabap.biercollection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.schaapkabap.biercollection.activitys.ItemListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Bierlist = (Button) findViewById(R.id.Listbutton);
        Button Firebase = (Button) findViewById(R.id.Firebasebutton);
        Button Grafieken = (Button) findViewById(R.id.Grafiekbutton);

        Bierlist.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.d("Bierbutton ingedrukt", "start Bierlist");
                startActivity(new Intent(MainActivity.this, com.example.schaapkabap.biercollection.activitys.ItemListActivity.class));
            }
        });

        Firebase.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.d("Firebasebutton ingedrukt", "start Firebase");
                startActivity(new Intent(MainActivity.this, com.example.schaapkabap.biercollection.activitys.Bierlist.class));
            }
        });

        Grafieken.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.d("Grafiekenbutton ingedrukt", "start Grafieken");
                startActivity(new Intent(MainActivity.this, com.example.schaapkabap.biercollection.activitys.Baractivity.class));
            }
        });
    }

}
