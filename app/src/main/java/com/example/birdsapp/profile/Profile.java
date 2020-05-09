package com.example.birdsapp.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.birdsapp.R;
import com.google.gson.Gson;

import java.io.*;

public class Profile implements Parcelable {
    public static final String SAVE_LINK = "ownerProfile";

    public final static String KEY = "profile";

    public final static String NAMES_KEY = "name";
    public final static String TITLE_KEY = "title";
    public final static String COUNTRY_KEY = "country";
    public final static String DESC_KEY = "description";
    public final static String IMG_KEY = "avatar";
    public final static String NO_IMG = "noImg";

    private String names;
    private String title;
    private String country;
    private String descript;
    private String image;

    public Profile(){
        names = "defaultName";
        title = "defaultTitle";
        country = "defaultCountry";
        descript = "defaultDescription";
        image = "noImg";
    }

    protected Profile(Parcel in) {
        names = in.readString();
        title = in.readString();
        country = in.readString();
        descript = in.readString();
        image = in.readString();
    }



    public String getImage() {
        return image;
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

    public static void saveImg(Bitmap bmp) throws IOException {
        String file_path = Environment.getExternalStorageDirectory().getAbsolutePath();
        File dir = new File(file_path);
        if(!dir.exists())
            dir.mkdirs();
        File file = new File(dir, SAVE_LINK + ".jpg");
        FileOutputStream fOut = new FileOutputStream(file);

        bmp.compress(Bitmap.CompressFormat.PNG, 85, fOut);
        fOut.flush();
        fOut.close();
    }

    public static Bitmap loadImg(){
        String file_path = Environment.getExternalStorageDirectory().getAbsolutePath() +
                "/"+SAVE_LINK + ".jpg";
        return BitmapFactory.decodeFile(file_path);
    }

    public static Profile load(SharedPreferences  mPrefs) {
        Gson gson = new Gson();
        String json = mPrefs.getString(KEY, "");
        System.out.println("LOADED");
        System.out.println(json);
        Profile saved = gson.fromJson(json, Profile.class);
        return (saved==null) ? new Profile() : saved;
    }

    public Bundle getBundle(){
        Bundle result = new Bundle();
        result.putString(NAMES_KEY,names);
        result.putString(COUNTRY_KEY,country);
        result.putString(TITLE_KEY,title);
        result.putString(DESC_KEY,descript);
        result.putString(IMG_KEY,image);
        return result;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(names);
        parcel.writeString(title);
        parcel.writeString(country);
        parcel.writeString(descript);
        parcel.writeString(image);
    }
    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
