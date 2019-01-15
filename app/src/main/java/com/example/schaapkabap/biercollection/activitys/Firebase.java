package com.example.schaapkabap.biercollection.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.schaapkabap.biercollection.MainActivity;
import com.example.schaapkabap.biercollection.Models.Bier;
import com.example.schaapkabap.biercollection.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Firebase extends AppCompatActivity {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("server/saving-data/fireblog");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        Button recensie = (Button) findViewById(R.id.recensiebutton);

        recensie.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.d("recensiebutton ingedrukt", "stuur de data");
                DatabaseReference usersRef = ref.child("Bier");

                Map<String, Bier> Biers = new HashMap<>();
                Biers.put("brouwer1", new Bier("Biertastisch" , "klein" ,"new york", "weg", "0238-42532422"));
                Biers.put("brouwer2", new Bier("Biertastisch2" , "klein2" ,"new york2", "weg2", "0238-42532422(2)"));

                usersRef.setValue(Biers);

            }
        });
    }

}
