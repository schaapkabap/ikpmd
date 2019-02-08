package com.example.schaapkabap.biercollection.helpers.Api;

import java.io.IOException;

interface ApiRequest {

    Object getById(String id) throws IOException;

    Object[] getAll() throws IOException;


}
