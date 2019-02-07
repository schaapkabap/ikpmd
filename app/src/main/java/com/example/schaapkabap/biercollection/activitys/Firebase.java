package com.example.schaapkabap.biercollection.activitys;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schaapkabap.biercollection.MainActivity;
import com.example.schaapkabap.biercollection.Models.Bier;
import com.example.schaapkabap.biercollection.Models.Recensie;
import com.example.schaapkabap.biercollection.R;
import com.example.schaapkabap.biercollection.helpers.FirebaseHelper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Firebase extends AppCompatActivity {

    Button mButton;
    EditText mEdit;
    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        FirebaseDatabase database;
        DatabaseReference myRef;
        final String TAG = MainActivity.class.getSimpleName();


        Button recensie = (Button) findViewById(R.id.recensiebutton);






        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");




        recensie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mEdit   = (EditText)findViewById(R.id.editText);
                mEdit.getText().toString();






                String key = myRef.child("message").push().getKey();
                Recensie recensie = new Recensie(mEdit.getText().toString());
                Map<String, Object> postValues = recensie.toMap();

                Map<String, Object> childUpdates = new HashMap<>();
                childUpdates.put("/recensies/" + key, postValues);


                myRef.updateChildren(childUpdates);

                CharSequence text = "Uw recensie is geplaats";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();


            }
        });







    }




}


