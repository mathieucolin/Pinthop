package com.example.mathieu.pinthop;

import java.util.ArrayList;

/**
 * Created by Mathieu on 10/05/2016.
 */
public class Bar {

    String nom_bar;
    String style;
    String style2;
    String style3;
    String adresse;
    String terrasse;
    String sportif;

    ArrayList<PlageHoraire> horaires;

    public String getNom_bar() {
        return nom_bar;
    }

    public void setNom_bar(String nom_bar) {
        this.nom_bar = nom_bar;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyle2() {
        return style2;
    }

    public void setStyle2(String style2) {
        this.style2 = style2;
    }

    public String getStyle3() {
        return style3;
    }

    public void setStyle3(String style3) {
        this.style3 = style3;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTerrasse() {
        return terrasse;
    }

    public void setTerrasse(String terrasse) {
        this.terrasse = terrasse;
    }

    public String getSportif() {
        return sportif;
    }

    public void setSportif(String sportif) {
        this.sportif = sportif;
    }

    public ArrayList<PlageHoraire> getHoraires() {
        return horaires;
    }

    public void setHoraires(ArrayList<PlageHoraire> horaires) {
        this.horaires = horaires;
    }

    public Bar(String nom_bar, String style, String style2, String style3, String adresse, String terrasse, String sportif, ArrayList<PlageHoraire> horaires) {

        this.nom_bar = nom_bar;
        this.style = style;
        this.style2 = style2;
        this.style3 = style3;
        this.adresse = adresse;
        this.terrasse = terrasse;
        this.sportif = sportif;
        this.horaires = horaires;
    }

    public Bar(){}
}
