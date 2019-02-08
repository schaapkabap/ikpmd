package com.example.schaapkabap.biercollection.helpers;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sosv.breweryDB.connector.configuration.IBreweryDBConnectorConfiguration;
import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.guice.BreweryDBAsyncModule;
import com.sosv.breweryDB.connector.guice.BreweryDBBaseModule;
import com.sosv.breweryDB.connector.service.IBreweryDBService;
import com.sosv.breweryDB.connector.service.async.IBreweryDBServiceAsync;
import com.sosv.breweryDB.connector.service.async.IResultCallback;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.filter.beer.BeersFilter;

import java.util.List;

public class ApiBeerCaller {

    public ApiBeerCaller() {
    }

    public void call() {

        System.out.println("start");

// Create the injector, the async module creates the sync and async object
        Injector injector = Guice.createInjector(new BreweryDBAsyncModule());

// Get the sync service
        final IBreweryDBService syncService = injector
                .getInstance(IBreweryDBService.class);
// Do some sync calls
        Beer result = null;
        try {
            result = syncService.getBeerById("cBLTUw");
        } catch (ApiKeyNotFoundExeption apiKeyNotFoundExeption) {
            apiKeyNotFoundExeption.printStackTrace();
        }
        System.out.println("Sync: " + result);
//Get beers by name
        List<Beer> salvator = null;
        try {
            salvator = syncService.getAllBeers(BeersFilter.createNameFilter("Salvator"));
        } catch (ApiKeyNotFoundExeption apiKeyNotFoundExeption) {
            apiKeyNotFoundExeption.printStackTrace();
        }
        System.out.println("Sync: " + salvator);

// Get the async service
        final IBreweryDBServiceAsync asyncService = injector
                .getInstance(IBreweryDBServiceAsync.class);

// Do some async calls
        asyncService.getAllBeers(new IResultCallback<List<Beer>>() {

            public void onSuccess(List<Beer> result) {
                System.out.println(result);
            }

            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });

        asyncService.getBeerById("cBLTUw", new IResultCallback<Beer>() {

            public void onSuccess(Beer result) {
                System.out.println("Async:" + result);
            }

            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });

        System.out.println("Done");
    }
}
