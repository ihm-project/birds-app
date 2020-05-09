package com.example.birdsapp.data;

import android.util.Log;

import com.example.birdsapp.R;
import com.example.birdsapp.models.Post;
import com.example.birdsapp.profile.Profile;

import org.osmdroid.util.GeoPoint;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostList {

    private static List<Post> posts;

    public static void initPostList(){
        posts = new ArrayList<>();
        posts.add(new Post(Species.MESANGE,new Profile(),new Date(),new GeoPoint(0.1,0),"post test",R.mipmap.mesange));
        posts.add(new Post(Species.MESANGE,new Profile(),new Date(),new GeoPoint(0.1,0),"post test",R.mipmap.mesange));
        posts.add(new Post(Species.MESANGE,new Profile(),new Date(),new GeoPoint(43.6265601,7.0996152),"rue de la caroute",R.mipmap.mesange));
        posts.add(new Post(Species.MESANGE,new Profile(),new Date(),new GeoPoint(43.6174848,7.1041023999999985),"post test",R.mipmap.mesange));
        posts.add((new Post()));
    }

    public static List<Post> getPosts() {
        return posts;
    }

    public static void addPost(Post e){
        posts.add(e);
        Log.d("ADDPOST", "addPost: "+e.toString());
    }

}
