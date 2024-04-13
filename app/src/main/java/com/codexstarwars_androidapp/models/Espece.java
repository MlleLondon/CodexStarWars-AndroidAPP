package com.codexstarwars_androidapp.models;

import java.io.Serializable;

public class Espece implements Serializable {
    private int id;
    private String nom, description, classification, taille,
            couleursCorps, couleursPoils, planete, habitat, langage,
            image;

    public Espece(int id, String nom, String description, String classification, String taille, String couleursCorps, String couleursPoils, String planete, String habitat, String langage, String image) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.classification = classification;
        this.taille = taille;
        this.couleursCorps = couleursCorps;
        this.couleursPoils = couleursPoils;
        this.planete = planete;
        this.habitat = habitat;
        this.langage = langage;
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

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getCouleursCorps() {
        return couleursCorps;
    }

    public void setCouleursCorps(String couleursCorps) {
        this.couleursCorps = couleursCorps;
    }

    public String getCouleursPoils() {
        return couleursPoils;
    }

    public void setCouleursPoils(String couleursPoils) {
        this.couleursPoils = couleursPoils;
    }

    public String getPlanete() {
        return planete;
    }

    public void setPlanete(String planete) {
        this.planete = planete;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getLangage() {
        return langage;
    }

    public void setLangage(String langage) {
        this.langage = langage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
