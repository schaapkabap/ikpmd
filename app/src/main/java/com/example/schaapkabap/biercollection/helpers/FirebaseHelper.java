package com.example.schaapkabap.biercollection.helpers;

import android.support.annotation.NonNull;
import android.telecom.Call;
import android.util.Log;

import com.example.schaapkabap.biercollection.Models.Bier;
import com.example.schaapkabap.biercollection.activitys.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FirebaseHelper {

    private static FirebaseHelper firebaseHelper;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("biers");
    DatabaseReference usersRef = ref.child("Bier");
    DatabaseReference data = ref.child("Bier");

    public Bier bier = new Bier();
    public List<Bier> arrayList = new ArrayList<Bier>();


    /**
     *
     */
    public FirebaseHelper() {
    }



    public void setData(Bier bier) {

        getJson(bier);
    }

    /**
     * @param bier
     */
    public void addData(Bier bier) {
        Map<String, Bier> biers = new HashMap<>();
        biers.put(bier.getNaam(), bier);
        usersRef.setValue(biers);
        biers.clear();

    }

    public void dataRequest(String bierBrouwerij) {
        DatabaseReference bier = usersRef.child(bierBrouwerij);
        readData(bier);
    }

    public Bier getBier() {
        return bier;
    }

    private void getJson(Bier bier) {

    }


    private void readData(DatabaseReference dbRefercence) {

        dbRefercence.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Bier bier = new Bier();
                bier.setStad(dataSnapshot.child("stad").getValue().toString());
                bier.setTelefoonnummer(dataSnapshot.child("telefoonnummer").getValue().toString());
                bier.setStaat(dataSnapshot.child("staat").getValue().toString());
                bier.setBrouwerij_type(dataSnapshot.child("brouwerij_type").getValue().toString());
                setBier(bier);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void setBier(Bier bier){
        this.bier= bier;
    }


}
