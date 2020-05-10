package com.example.birdsapp.data;

import com.example.birdsapp.R;

public enum Species{
    PIGEON("Pigeon", R.mipmap.pigeon, "https://fr.wikipedia.org/wiki/Columba_(oiseau)"),
    TOURTERELLE("Tourterelle", R.mipmap.tourterelle, "https://fr.wikipedia.org/wiki/Tourterelle"),
    MOINEAU("Moineau", R.mipmap.moineau, "https://fr.wikipedia.org/wiki/Moineau"),
    MESANGE("Mesange", R.mipmap.mesange, "https://fr.wikipedia.org/wiki/M%C3%A9sange");

    public String name;
    public int img;
    private String url;

    Species(String name, int img) {
        this.name = name;
        this.url = "";
        this.img = img;
    }

    Species(String name, int img, String url) {
        this.name = name;
        this.url = url;
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
