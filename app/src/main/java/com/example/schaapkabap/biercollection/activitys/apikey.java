package com.example.schaapkabap.biercollection.activitys;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.schaapkabap.biercollection.MainActivity;

public class apikey {

    SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putInt(getString(R.string.saved_high_score_key), newHighScore);
    editor.commit();
}
