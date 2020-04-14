package com.example.birdsapp.data;

public enum Species {
    PIGEON("Pigeon"), TOURTERELLE("Tourterelle"), MOINEAU("Moineau"), MESANGE("Mesange");

    private String name;

    Species(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
