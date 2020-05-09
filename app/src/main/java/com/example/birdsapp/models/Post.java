package com.example.birdsapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.birdsapp.R;
import com.example.birdsapp.data.Species;
import com.example.birdsapp.profile.Profile;

import org.osmdroid.util.GeoPoint;

import java.util.Date;

public class Post implements Parcelable {

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

    protected Post(Parcel in) {
        specy = Species.valueOf(in.readString());
        profile = in.readParcelable(Profile.class.getClassLoader());
        date= new Date(in.readLong());
        geoPoint = in.readParcelable(GeoPoint.class.getClassLoader());
        description = in.readString();
        like = in.readInt();
        photo = in.readInt();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(specy.name());
        parcel.writeParcelable(profile,i);
        parcel.writeLong(date.getTime());
        parcel.writeParcelable(geoPoint,i);
        parcel.writeString(description);
        parcel.writeInt(like);
        parcel.writeInt(photo);
    }

    @NonNull
    @Override
    public String toString() {
        return "Specy :"+specy.toString()+",\n"+
                "Profile :"+profile+",\n"+
                "Date :"+date.toString()+",\n"+
                "GeoPoint :"+geoPoint.toString()+",\n"
                +"Likes :"+like+"\n,"
                +"description :"+description+",\n"+
                "photo :"+photo;
    }
}


