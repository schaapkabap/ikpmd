package com.example.schaapkabap.biercollection.helpers.Api;

import android.util.Log;

import com.example.schaapkabap.biercollection.Models.ApiBier;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiHandler implements ApiRequest {

    private static ApiHandler instance;
    private static HttpHandler httpHandler;
    //TODO naar api  mkey van bestand ophalen.
    private String apikey = "?key=37f34d7d9ce37224e5cf94b33db59ab3";
    private final String domain = "https://api.brewerydb.com/v2/";

    private ApiHandler() {
    }

    public static ApiHandler getInstance() {
        if (instance == null) {
            instance = new ApiHandler();
            httpHandler = new HttpHandler();
        }
        return instance;
    }

    //TODO waarde terug gooien
    @Override
    public Object getById(String id) throws IOException {
        String url = urlBuilder("beer/" + id);
        String json = httpHandler.makeServiceCall(url);
        return null;
    }


    @Override
    public List<ApiBier> getAll() throws IOException, JSONException {
        String url = urlBuilder("beers");
        String json = httpHandler.makeServiceCall(url);


        JSONObject jObject = new JSONObject(json);
        System.out.println(jObject.toString());

        List list= new ArrayList<Object>();
        JSONArray jsonArray = jObject.getJSONArray("data");
        Log.d("Birs",jObject.getJSONArray("data").toString());
        for(int i = 0 ; i < jsonArray.length(); i++){
            ApiBier apiBier = new ApiBier();
            if(jsonArray.getJSONObject(i).has("id")){
                apiBier.setId(jsonArray.getJSONObject(i).getString("id"));
                Log.d("bierkey",apiBier.getId());
            }
            if(jsonArray.getJSONObject(i).has("abv")){
                apiBier.setAbv(jsonArray.getJSONObject(i).getString("abv"));
            }
            if (jsonArray.getJSONObject(i).has("name")){
                apiBier.setName(jsonArray.getJSONObject(i).getString("name"));
            }
            list.add(apiBier);
        }

        Log.d("biers",list.toString());

        return list;
    }


    private String urlBuilder(String path) {
        String url = domain + path + "/" + apikey;
        return url;

    }
}
