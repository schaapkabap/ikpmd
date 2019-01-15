package com.example.schaapkabap.biercollection.helpers;

import com.example.schaapkabap.biercollection.Models.Bier;
import com.example.schaapkabap.biercollection.activitys.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper {

    private static FirebaseHelper firebaseHelper;
    private String Uri;
    private DatabaseReference reference;


    public FirebaseHelper() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("server/saving-data/fireblog");
    }

    public static synchronized FirebaseHelper getInstance() {
        if (firebaseHelper == null)
            firebaseHelper = new FirebaseHelper();
        return firebaseHelper;
    }

    public void setData(Bier bier) {

        getJson(bier);
        // Get the root reference location of the database.


    }

    public void addData(Bier bier) {
//        bier
//        mDatabaseRef.Child("users").Child(userId).SetRawJsonValueAsync(json);

    }

    public Bier getData() {
        return null;
    }

    private String getJson(Bier bier) {

        return null;
    }
}
