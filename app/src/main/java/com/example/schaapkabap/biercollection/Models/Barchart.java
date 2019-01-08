package com.example.schaapkabap.biercollection.Models;

import java.io.Serializable;

public class Barchart {

    private String staatnaam;

    public Barchart(String staatnaam) {
        this.staatnaam = staatnaam;
    }

    public Barchart(){

    }

    public String getStaatnaam() {
        return staatnaam;
    }

    public void setStaatnaam(String staatnaam) {
        this.staatnaam = staatnaam;
    }
}

