package com.example.mathieu.pinthop;

/**
 * Created by Mathieu on 10/05/2016.
 */
public class PlageHoraire {

    String ouverture;
    String fermeture;

    public PlageHoraire(String ouverture, String fermeture) {
        this.ouverture = ouverture;
        this.fermeture = fermeture;
    }

    public String getOuverture() {
        return ouverture;
    }

    public void setOuverture(String ouverture) {
        this.ouverture = ouverture;
    }

    public String getFermeture() {
        return fermeture;
    }

    public void setFermeture(String fermeture) {
        this.fermeture = fermeture;
    }

    public PlageHoraire(){}
}
