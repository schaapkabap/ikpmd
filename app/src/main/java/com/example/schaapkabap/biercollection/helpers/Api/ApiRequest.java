package com.example.schaapkabap.biercollection.helpers.Api;

import com.example.schaapkabap.biercollection.Models.ApiBier;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

interface ApiRequest {

    Object getById(String id) throws IOException, JSONException;

    List<ApiBier> getAll() throws IOException, JSONException;


}
