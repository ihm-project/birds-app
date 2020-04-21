package com.example.birdsapp.models;

import com.example.birdsapp.R;
import com.example.birdsapp.data.Species;
import com.example.birdsapp.profile.Profile;

import org.osmdroid.util.GeoPoint;

import java.util.Date;

public class Post {

    Species specy;
    Profile profile;
    Date date;
    GeoPoint geoPoint;
    int like;
    String description;
    int photo;

    public Post(){
        specy= Species.PIGEON;
        profile= new Profile();
        date = new Date();
        this.geoPoint= new GeoPoint(0.1,0.1);
        like=0;
        description="default description";
        photo= R.mipmap.pigeon;
    }
    public Post(Species specy, Profile profile, Date date, GeoPoint geoPoint, String description, int photo){
        this.specy=specy;
        this.profile=profile;
        this.date=date;
        this.geoPoint=geoPoint;
        this.description=description;
        this.photo=photo;
        this.like=0;
    }

    public Post(Species specy, Profile profile, Date date, GeoPoint geoPoint, String description){
        this.specy=specy;
        this.profile=profile;
        this.date=date;
        this.geoPoint=geoPoint;
        this.description=description;
        this.like=0;
        this.photo= R.mipmap.pigeon;

    }

    public Date getDate() {
        return date;
    }

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }

    public int getLike() {
        return like;
    }

    public Profile getProfile() {
        return profile;
    }

    public Species getSpecy() {
        return specy;
    }

    public String getDescription() {
        return description;
    }

    public int getPhoto() {
        return photo;
    }

}


