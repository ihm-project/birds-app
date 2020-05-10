package com.example.birdsapp.data;

import com.example.birdsapp.R;
import com.example.birdsapp.models.Bird;

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

    public static int findMipmap(Species species){
        if(birds==null) initBirdsList();
        for (Bird bird : birds) if (bird.getSpecies().equals(species)) return bird.getPicture();
        return 0;
    }
}
