package com.example.birdsapp.data;

import com.example.birdsapp.R;

import java.util.ArrayList;
import java.util.List;

public class BirdsList {

    private static List<Bird> birds;

    public static void initBirdsList() {
        birds = new ArrayList<>();
        birds.add(new Bird(R.mipmap.mesange, Species.MESANGE));
        birds.add(new Bird(R.mipmap.moineau, Species.MOINEAU));
        birds.add(new Bird(R.mipmap.pigeon, Species.PIGEON));
        birds.add(new Bird(R.mipmap.tourterelle, Species.TOURTERELLE));
    }

    public static List<Bird> getBirds() {
        return birds;
    }
}