package com.example.birdsapp.data;

import com.example.birdsapp.R;

import java.util.ArrayList;
import java.util.List;

public class BirdsList {

    private static List<Bird> birds;

    public static void initBirdsList() {
        birds = new ArrayList<>();
        for (Species s : Species.values()){
            birds.add(new Bird(s.img, s));
        }
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
