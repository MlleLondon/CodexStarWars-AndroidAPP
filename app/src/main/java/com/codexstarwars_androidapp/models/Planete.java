package com.codexstarwars_androidapp.models;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class Planete implements Serializable {
        int id, nbLunes;
        private String name, description, region, systeme, type, diametre, population, image;
        public Planete(int id, int nbLunes, String name, String description, String region, String systeme, String type, String diametre, String population, String image) {
            this.id = id;
            this.nbLunes = nbLunes;
            this.name = name;
            this.description = description;
            this.region = region;
            this.systeme = systeme;
            this.type = type;
            this.diametre = diametre;
            this.population = population;
            this.image = image;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbLunes() {
        return nbLunes;
    }

    public void setNbLunes(int nbLunes) {
        this.nbLunes = nbLunes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSysteme() {
        return systeme;
    }

    public void setSysteme(String systeme) {
        this.systeme = systeme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDiametre() {
        return diametre;
    }

    public void setDiametre(String diametre) {
        this.diametre = diametre;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
        public boolean equals(@Nullable Object obj) {
            Planete p = (Planete) obj;
            return id == p.getId();
        }
    }


