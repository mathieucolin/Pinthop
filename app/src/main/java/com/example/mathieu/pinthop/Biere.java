package com.example.mathieu.pinthop;

/**
 * Created by Mathieu on 10/05/2016.
 */
public class Biere{

    String nom;
    String nationalite;
    String type;
    String type2;
    String couleur;
    String brasserie;
    String methodebrassage;
    String degrealcool;
    String commentaires;
    String commonname;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getBrasserie() {
        return brasserie;
    }

    public void setBrasserie(String brasserie) {
        this.brasserie = brasserie;
    }

    public String getMethodebrassage() {
        return methodebrassage;
    }

    public void setMethodebrassage(String methodebrassage) {
        this.methodebrassage = methodebrassage;
    }

    public String getDegrealcool() {
        return degrealcool;
    }

    public void setDegrealcool(String degrealcool) {
        this.degrealcool = degrealcool;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public String getCommonname() {
        return commonname;
    }

    public void setCommonname(String commonname) {
        this.commonname = commonname;
    }

    public String getPrix_hors_hh() {
        return prix_hors_hh;
    }

    public void setPrix_hors_hh(String prix_hors_hh) {
        this.prix_hors_hh = prix_hors_hh;
    }

    public String getPrix_hh() {
        return prix_hh;
    }

    public void setPrix_hh(String prix_hh) {
        this.prix_hh = prix_hh;
    }

    public String getConditionnement() {
        return conditionnement;
    }

    public void setConditionnement(String conditionnement) {
        this.conditionnement = conditionnement;
    }

    public Biere(String nom, String nationalite, String type, String type2, String couleur, String brasserie, String methodebrassage, String degrealcool, String commentaires, String commonname, String prix_hors_hh, String prix_hh, String conditionnement) {

        this.nom = nom;
        this.nationalite = nationalite;
        this.type = type;
        this.type2 = type2;
        this.couleur = couleur;
        this.brasserie = brasserie;
        this.methodebrassage = methodebrassage;
        this.degrealcool = degrealcool;
        this.commentaires = commentaires;
        this.commonname = commonname;
        this.prix_hors_hh = prix_hors_hh;
        this.prix_hh = prix_hh;
        this.conditionnement = conditionnement;
    }

    String prix_hors_hh;
    String prix_hh;
    String conditionnement;


    @Override
    public String toString() {
        return nom + " " + prix_hors_hh + "€ " + "HH : " + prix_hh + "€ " + "en " + conditionnement;
    }

    public Biere(String prix_hors_hh, String prix_hh, String conditionnement) {

        this.prix_hors_hh = prix_hors_hh;
        this.prix_hh = prix_hh;
        this.conditionnement = conditionnement;
    }

    public Biere(String nom, String nationalite, String type, String type2, String couleur, String brasserie, String methodebrassage, String degrealcool, String commentaires, String commonname) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.type = type;
        this.type2 = type2;
        this.couleur = couleur;
        this.brasserie = brasserie;
        this.methodebrassage = methodebrassage;
        this.degrealcool = degrealcool;
        this.commentaires = commentaires;
        this.commonname = commonname;
    }

    public Biere(String nom_biere, String prix_hors_hh, String prix_hh, String conditionnement) {
        this.nom = nom_biere;
        this.prix_hors_hh = prix_hors_hh;
        this.prix_hh = prix_hh;
        this.conditionnement = conditionnement;
    }

    public Biere(){}

}
