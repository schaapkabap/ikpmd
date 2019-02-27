package com.example.schaapkabap.biercollection.helpers.Api;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HttpHandler extends AsyncTask<String, Integer, Long> {
    private static final String TAG = HttpHandler.class.getSimpleName();

    public HttpHandler() {
    }

    @Override
    protected Long doInBackground(String... strings) {
        return null;
    }

    public String makeServiceCall(String reqUrl) throws IOException {

        InputStream is = null;
        URL url = new URL(reqUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(30000); // time in milliseconds
        conn.setConnectTimeout(70000); // time in milliseconds
        conn.setRequestMethod("GET"); // request method GET OR POST
        conn.setDoInput(true);
        conn.connect(); // calling the web address
        int response = conn.getResponseCode();
        Log.d(TAG, "The response is: " + response);
        is = conn.getInputStream();

        // Convert the InputStream into a string
        String contentAsString = readInputStream(is);
        return contentAsString;
    }

    // Reads an InputStream and converts it to a String.
    public static String readInputStream(InputStream stream) throws IOException {
        int n = 0;
        char[] buffer = new char[1024 * 4];
        InputStreamReader reader = new InputStreamReader(stream, "UTF8");
        StringWriter writer = new StringWriter();
        while (-1 != (n = reader.read(buffer)))
            writer.write(buffer, 0, n);
        return writer.toString();
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}
