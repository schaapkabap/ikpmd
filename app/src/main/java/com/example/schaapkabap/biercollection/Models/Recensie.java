package com.example.schaapkabap.biercollection.Models;


public class Recensie {

    private String recensietekst;
    private int rating;
    private  Bier bier;


    public Recensie() {
    }


    public String getRecensietekst() {
        return recensietekst;
    }

    public void setRecensietekst(String recensietekst) {
        this.recensietekst = recensietekst;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Bier getBier() {
        return bier;
    }

    public void setBier(Bier bier) {
        this.bier = bier;
    }
}


