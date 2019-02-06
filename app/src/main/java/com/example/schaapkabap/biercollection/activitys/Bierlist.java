package com.example.schaapkabap.biercollection.activitys;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.schaapkabap.biercollection.MainActivity;
import com.example.schaapkabap.biercollection.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

public class Bierlist extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    //private ListView lv;

    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bierlist);

        //contactList = new ArrayList<>();
        //lv = (ListView) findViewById(R.id.list);

        new GetContacts().execute();

        //SearchView simpleSearchView = (SearchView) findViewById(R.id.simpleSearchView);
        //CharSequence query = simpleSearchView.getQuery();

    }

    public void makeToastMessage(){
        CharSequence text = "BIER";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(Bierlist.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://api.openbrewerydb.org/breweries/";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("contacts");

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);
                        String name = c.getString("name");
                        String brewery_type = c.getString("brewery_type");
                        String city = c.getString("city");
                        String state = c.getString("state");
                        String phone = c.getString("phone");

                        // Phone node is JSON Object
                        //JSONObject phone = c.getJSONObject("phone");
                        //String mobile = phone.getString("mobile");
                        //String home = phone.getString("home");
                        //String office = phone.getString("office");

                        // tmp hash map for single contact
                        //HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        //contact.put("id", id);
                        //contact.put("name", name);
                        //contact.put("email", email);
                        //contact.put("mobile", mobile);

                        // adding contact to contact list
                        //contactList.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        //@Override
        //protected void onPostExecute(Void result) {
            //super.onPostExecute(result);
            //ListAdapter adapter = new SimpleAdapter(Bierlist.this, contactList,
                    //R.layout.list_item, new String[]{ "email","mobile"},
                    //new int[]{R.id.email, R.id.mobile});
            //lv.setAdapter(adapter);
        }


}
