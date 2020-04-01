package com.example.birdsapp.profile;

import android.content.Context;
import android.os.Bundle;

import com.example.birdsapp.R;

import java.io.*;

public class Profile {
    private final String SAVE_LINK = "ownerProfile.txt";

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

    public void save(String fileName, Context context) throws IOException {
        FileOutputStream fos =  context.openFileOutput(fileName, Context.MODE_PRIVATE);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(this);
        os.close();
        fos.close();
    }

    public static Profile load(String fileName, Context context) throws IOException, ClassNotFoundException {
        FileInputStream fis = context.openFileInput(fileName);
        ObjectInputStream is = new ObjectInputStream(fis);
        Profile profile = (Profile) is.readObject();
        is.close();
        fis.close();
        return profile;
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
}
