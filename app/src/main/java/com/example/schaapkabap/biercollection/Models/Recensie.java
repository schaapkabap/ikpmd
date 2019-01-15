package com.example.schaapkabap.biercollection.Models;

public class Recensie {
    private int cijfer;
    private String recensietekst;
    private Bier bier;

    public Recensie(int cijfer, String recensietekst, Bier bier) {
        this.cijfer = cijfer;
        this.recensietekst = recensietekst;
        this.bier = bier;
    }

    public Recensie() {
    }

    public Bier getBier() {
        return bier;
    }

    public void setBier(Bier bier) {
        this.bier = bier;
    }

    public int getCijfer() {
        return cijfer;
    }

    public void setCijfer(int cijfer) {
        this.cijfer = cijfer;
    }

    public String getRecensietekst() {
        return recensietekst;
    }

    public void setRecensietekst(String recensietekst) {
        this.recensietekst = recensietekst;
    }
}
