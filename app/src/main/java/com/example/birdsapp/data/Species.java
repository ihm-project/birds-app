package com.example.birdsapp.data;

public enum Species {
    PIGEON("Pigeon", "https://fr.wikipedia.org/wiki/Columba_(oiseau)"),
    TOURTERELLE("Tourterelle", "https://fr.wikipedia.org/wiki/Tourterelle"),
    MOINEAU("Moineau", "https://fr.wikipedia.org/wiki/Moineau"),
    MESANGE("Mesange");

    private String name;
    private String url;

    Species(String name) {
        this.name = name;
        this.url = "";
    }

    Species(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
