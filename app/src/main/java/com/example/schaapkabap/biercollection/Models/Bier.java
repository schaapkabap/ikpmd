package com.example.schaapkabap.biercollection.Models;

import java.io.Serializable;

public class Bier {
    private String naam;
    private String brouwerij_type;
    private String stad;
    private String staat;
    private String telefoonnummer;

    public Bier(String naam, String brouwerij_type, String stad, String staat, String telefoonnummer) {
        this.naam = naam;
        this.brouwerij_type = brouwerij_type;
        this.stad = stad;
        this.staat = staat;
        this.telefoonnummer = telefoonnummer;
    }

    public Bier(){

    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBrouwerij_type() {
        return brouwerij_type;
    }

    public void setBrouwerij_type(String brouwerij_type) {
        this.brouwerij_type = brouwerij_type;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getStaat() {
        return staat;
    }

    public void setStaat(String staat) {
        this.staat = staat;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }
}
