package com.example.birdsapp.models;

import com.example.birdsapp.data.Species;

public class Bird {

    private int picture;
    private Species species;

    public Bird(int picture, Species species) {
        this.picture = picture;
        this.species = species;
    }

    public int getPicture() {
        return picture;
    }

    public Species getSpecies() {
        return species;
    }

    public String getUrl() {
        return species.getUrl();
    }
}
