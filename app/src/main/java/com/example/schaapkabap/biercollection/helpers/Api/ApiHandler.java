package com.example.schaapkabap.biercollection.helpers.Api;

import android.util.Log;

import com.example.schaapkabap.biercollection.Models.ApiBier;
import com.google.android.gms.common.api.Api;

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
    private String apikey;
    private final String domain = "https://sandbox-api.brewerydb.com/v2/";

    private ApiHandler() {
    }

    /**
     *
     * @param key Apikey of dbbrewerys
     * @return
     */
    public static ApiHandler getInstance(String key) {
        if (instance == null) {
            instance = new ApiHandler();
            httpHandler = new HttpHandler();
        }
        instance.apikey = "key=" +key;
        return instance;
    }

    @Override
    public Object getById(String id) throws IOException, JSONException {
        String url = urlBuilder("beer/" + id);
        String json = httpHandler.makeServiceCall(url);
        JSONObject jObject = new JSONObject(json);


        ApiBier apiBier = new ApiBier();
        apiBier.setId(id);
        if (jObject.has("name")) {
            apiBier.setName(jObject.getString("name"));
        }
        if (jObject.has("abv")) {
            apiBier.setAbv(jObject.getString("abv"));
        }

        return apiBier;
    }


    @Override
    public List<ApiBier> getAll() throws IOException, JSONException {
        String url = urlBuilder("beers");
        String json = httpHandler.makeServiceCall(url);

        JSONObject jObject = new JSONObject(json);
        JSONArray jsonArray = jObject.getJSONArray("data");
        List<ApiBier> list =  jsonArrayToBierList(jsonArray);


        return list;
    }
//TODO set a new urlBuilder for searchterm
    public List<ApiBier> search(String searchterm) throws IOException, JSONException {
        if(searchterm == null){
            return null;
        }
        String url = domain + "search?q=" + searchterm + "&type=beer"+ "&"+ apikey;
        String json = httpHandler.makeServiceCall(url);
        JSONObject jObject = new JSONObject(json);
        JSONArray jsonArray = jObject.getJSONArray("data");
        List<ApiBier> list =  jsonArrayToBierList(jsonArray);
        return list;

    }

    private List<ApiBier> jsonArrayToBierList(JSONArray jsonArray) throws JSONException {
        List list = new ArrayList<Object>();
        for (int i = 0; i < jsonArray.length(); i++) {
            ApiBier apiBier = new ApiBier();
            if (jsonArray.getJSONObject(i).has("id")) {
                apiBier.setId(jsonArray.getJSONObject(i).getString("id"));
                Log.d("bierkey", apiBier.getId());
            }
            if (jsonArray.getJSONObject(i).has("abv")) {
                apiBier.setAbv(jsonArray.getJSONObject(i).getString("abv"));
            }
            if (jsonArray.getJSONObject(i).has("name")) {
                apiBier.setName(jsonArray.getJSONObject(i).getString("name"));
            }
            if (jsonArray.getJSONObject(i).has("labels")) {

               apiBier.setUrlImage((String) jsonArray.getJSONObject(i).getJSONObject("labels").get("large"));
            }
            list.add(apiBier);
        }
        return list;
    }

    private String urlBuilder(String path) {
        String url = domain + path + "/?" + apikey;
        return url;

    }
}
