package com.example.schaapkabap.biercollection.helpers;

import android.support.annotation.NonNull;

import com.example.schaapkabap.biercollection.Models.Bier;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseHelper {

    private static FirebaseHelper firebaseHelper;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private String key;
    private DatabaseReference myRef;
    public Bier bier = new Bier();
    public List<Bier> arrayList = new ArrayList<Bier>();


    public FirebaseHelper() {
    }

    public void setReferentie(String referentie) {
        this.myRef = database.getReference(referentie);
        this.key = myRef.child(referentie).push().getKey();

    }


    /**
     * @param obj
     */
    public void addData(Object obj) {

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(key, obj);
        myRef.updateChildren(childUpdates);

    }

    public void dataRequest(String bierBrouwerij) {

//        readData(bier);
    }

    public Bier getBier() {
        return bier;
    }


    private void readData(DatabaseReference dbRefercence) {

        dbRefercence.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Bier bier = new Bier();
                bier.setCity(dataSnapshot.child("stad").getValue().toString());
                bier.setPhone(dataSnapshot.child("telefoonnummer").getValue().toString());
                bier.setStreet(dataSnapshot.child("staat").getValue().toString());
                bier.setBrewery_type(dataSnapshot.child("brouwerij_type").getValue().toString());
                setBier(bier);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void setBier(Bier bier) {
        this.bier = bier;
    }


}
