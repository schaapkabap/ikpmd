package com.example.schaapkabap.biercollection.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.schaapkabap.biercollection.Models.Bier;
import com.example.schaapkabap.biercollection.R;
import com.example.schaapkabap.biercollection.helpers.FirebaseHelper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Firebase extends AppCompatActivity {
    private FirebaseHelper firebaseHelper = new FirebaseHelper();
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("server/saving-data/fireblog");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        Button recensie = (Button) findViewById(R.id.recensiebutton);

        recensie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("recensiebutton ingedrukt", "stuur de data");
                Bier bier1 = new Bier("tratyata", "klein2", "new york", "weg", "0238-42532422");
               firebaseHelper.addData(bier1);
                firebaseHelper.dataRequest("Biertastisch");
                Bier bier = firebaseHelper.getBier();
                System.out.println(bier.getNaam());


            }
        });
    }


}


