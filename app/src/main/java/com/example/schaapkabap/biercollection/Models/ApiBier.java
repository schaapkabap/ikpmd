package com.example.schaapkabap.biercollection.Models;

public class ApiBier {
    private String id;
    private String name;
    // Alcohol percentage
    private String abv;


    public ApiBier() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }
}
