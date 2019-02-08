package com.example.schaapkabap.biercollection.helpers.Api;

import java.io.IOException;

public class ApiHandler implements ApiRequest {

    private static ApiHandler instance;
    private HttpHandler httpHandler;
    //TODO naar api  mkey van bestand ophalen.
    private String apikey = null;
    private final String domain = "https://api.brewerydb.com/v2/";

    private ApiHandler() {
    }

    public ApiHandler getInstance(String apikey) {
        if (instance == null) {
            instance = new ApiHandler();
        }
        this.apikey = apikey;
        return instance;
    }


    @Override
    public Object getById(String id) throws IOException {
        String url = urlBuilder("beer/" + id);
        String json = httpHandler.makeServiceCall(url);

        return null;
    }

    @Override
    public Object[] getAll() throws IOException {
        String url = urlBuilder("beers");
        String json = httpHandler.makeServiceCall(url);

        return null;
    }

    private String urlBuilder(String path) {
        String url = domain + path + apikey;
        return url;

    }
}
