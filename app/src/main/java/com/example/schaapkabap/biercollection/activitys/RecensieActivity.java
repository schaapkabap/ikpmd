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

public class RecensieActivity extends AppCompatActivity implements DataLink {

    private EditText mEdit;
    private EditText rating;
    private Button recensie;
    private FirebaseHelper firebaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        final String TAG = MainActivity.class.getSimpleName();

        this.elementLinker();
        this.fireBaseConnector();
        recensie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //build recensie
                Recensie recensie = new Recensie();
                recensie.setRecensietekst(mEdit.getText().toString());
                recensie.setRating(Integer.parseInt(rating.getText().toString()));
                getFirebaseHelper().addData(recensie);

                CharSequence text = "Uw recensie is geplaats";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();
            }
        });


    }

    public FirebaseHelper getFirebaseHelper() {
        return firebaseHelper;
    }

    public void setFirebaseHelper(FirebaseHelper firebaseHelper) {
        this.firebaseHelper = firebaseHelper;
    }

    public void fireBaseConnector() {
            this.firebaseHelper = new FirebaseHelper();
            this.firebaseHelper.setReferentie("recensies");

    }


    @Override
    public void elementLinker() {
        recensie = (Button) findViewById(R.id.recensiebutton);
        mEdit = (EditText) findViewById(R.id.editText);
        rating = (EditText) findViewById(R.id.rating);
    }
}


