package com.codexstarwars_androidapp.models;

import java.io.Serializable;

public class Personnage implements Serializable {

    private int id;
    private String nom, description, alias, dateNaissance, lieuNaissance, dateMort, lieuMort, espece, genre, image;

    public Personnage(int id, String nom, String description, String alias, String dateNaissance, String lieuNaissance, String dateMort, String lieuMort, String espece, String genre, String image) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.alias = alias;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.dateMort = dateMort;
        this.lieuMort = lieuMort;
        this.espece = espece;
        this.genre = genre;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getDateMort() {
        return dateMort;
    }

    public void setDateMort(String dateMort) {
        this.dateMort = dateMort;
    }

    public String getLieuMort() {
        return lieuMort;
    }

    public void setLieuMort(String lieuMort) {
        this.lieuMort = lieuMort;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
