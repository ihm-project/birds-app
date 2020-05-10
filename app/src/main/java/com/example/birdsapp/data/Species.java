package com.example.birdsapp.data;

import com.example.birdsapp.R;

public enum Species{
    PIGEON("Pigeon", R.mipmap.pigeon),
    TOURTERELLE("Tourterelle", R.mipmap.tourterelle),
    MOINEAU("Moineau", R.mipmap.moineau),
    MESANGE("Mesange", R.mipmap.mesange);

    public String name;
    public int img;

    Species(String name, int img) {
        this.name = name;
        this.img = img;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
