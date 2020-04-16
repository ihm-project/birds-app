package com.example.birdsapp.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.birdsapp.R;
import com.google.gson.Gson;

import java.io.*;

public class Profile {
    public static final String SAVE_LINK = "ownerProfile";

    public final static String KEY = "profile";

    public final static String NAMES_KEY = "name";
    public final static String TITLE_KEY = "title";
    public final static String COUNTRY_KEY = "country";
    public final static String DESC_KEY = "description";
    public final static String IMG_KEY = "avatar";

    private String names;
    private String title;
    private String country;
    private String descript;
    private int image;

    public Profile(){
        names = "defaultName";
        title = "defaultTitle";
        country = "defaultCountry";
        descript = "defaultDescription";
        image = R.mipmap.ic_launcher;
    }

    public String getNames() {
        return names;
    }

    public String getTitle() {
        return title;
    }

    public String getDescript() {
        return descript;
    }

    public String getCountry() {
        return country;
    }

    public void save(SharedPreferences  mPrefs) {
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(this);
        prefsEditor.putString(KEY, json);
        prefsEditor.commit();
        System.out.println("SAVED");
        System.out.println(json);
        System.out.println(mPrefs.getString(KEY, ""));
    }

    public static Profile load(SharedPreferences  mPrefs) {
        Gson gson = new Gson();
        String json = mPrefs.getString(KEY, "");
        System.out.println("LOADED");
        System.out.println(mPrefs);
        Profile saved = gson.fromJson(json, Profile.class);
        return (saved==null) ? new Profile() : saved;
    }

    public Bundle getBundle(){
        Bundle result = new Bundle();
        result.putString(NAMES_KEY,names);
        result.putString(COUNTRY_KEY,country);
        result.putString(TITLE_KEY,title);
        result.putString(DESC_KEY,descript);
        result.putInt(IMG_KEY,image);
        return result;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
