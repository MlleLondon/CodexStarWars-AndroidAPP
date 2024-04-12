package com.codexstarwars_androidapp.models;

public class Vaisseau {
    private int id;
    private String nom, description, longueur, vitesse, moteur, equipage, image;

    public Vaisseau(int id, String nom, String description, String longueur, String vitesse, String moteur, String equipage, String image) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.longueur = longueur;
        this.vitesse = vitesse;
        this.moteur = moteur;
        this.equipage = equipage;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLongueur() {
        return longueur;
    }

    public void setLongueur(String longueur) {
        this.longueur = longueur;
    }

    public String getVitesse() {
        return vitesse;
    }

    public void setVitesse(String vitesse) {
        this.vitesse = vitesse;
    }

    public String getMoteur() {
        return moteur;
    }

    public void setMoteur(String moteur) {
        this.moteur = moteur;
    }

    public String getEquipage() {
        return equipage;
    }

    public void setEquipage(String equipage) {
        this.equipage = equipage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
