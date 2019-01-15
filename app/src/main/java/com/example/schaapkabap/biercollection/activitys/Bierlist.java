package com.example.schaapkabap.biercollection.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.schaapkabap.biercollection.R;

public class Bierlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bierlist);

        SearchView simpleSearchView = (SearchView) findViewById(R.id.simpleSearchView);
        CharSequence query = simpleSearchView.getQuery();
    }

    public void makeToastMessage(){
        CharSequence text = "BIER";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }
}
