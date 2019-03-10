package com.example.schaapkabap.biercollection.activitys;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.schaapkabap.biercollection.MainActivity;
import com.example.schaapkabap.biercollection.Models.Bier;

public class Bierlist extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();


    public void makeToastMessage() {
        CharSequence text = "BIER";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }




}
