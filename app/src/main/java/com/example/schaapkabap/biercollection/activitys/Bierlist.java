package com.example.schaapkabap.biercollection.activitys;

import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.schaapkabap.biercollection.MainActivity;
import com.example.schaapkabap.biercollection.Models.Bier;
import com.example.schaapkabap.biercollection.R;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bierlist extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();


    public void makeToastMessage() {
        CharSequence text = "BIER";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }




}
