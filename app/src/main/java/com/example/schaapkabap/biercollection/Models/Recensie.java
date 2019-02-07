package com.example.schaapkabap.biercollection.Models;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;


public class Recensie {

    Button mButton;
    EditText mEdit;
    TextView mText;

    private String recensietekst;

    public Recensie(String recensietekst) {

        this.recensietekst = recensietekst;

    }

    public Recensie() {
    }
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("recensietekst", recensietekst);


        return result;
    }

    public String getRecensietekst() {
        return recensietekst;
    }

    public void setRecensietekst(String recensietekst) {
        this.recensietekst = recensietekst;
    }
}


