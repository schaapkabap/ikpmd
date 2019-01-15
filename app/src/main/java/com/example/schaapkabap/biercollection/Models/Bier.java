package com.example.schaapkabap.biercollection.Models;

import java.io.Serializable;

public class Bier {
    private String name;
    private String brewery_type;
    private String city;
    private String state;
    private String phone;

    public Bier(String name, String brewery_type, String city, String state, String phone) {
        this.name = name;
        this.brewery_type = brewery_type;
        this.city = city;
        this.state = state;
        this.phone = phone;
    }

    public Bier() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrewery_type() {
        return brewery_type;
    }

    public void setBrewery_type(String brewery_type) {
        this.brewery_type = brewery_type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
