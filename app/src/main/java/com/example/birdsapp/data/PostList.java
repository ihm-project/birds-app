package com.example.birdsapp.data;

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
        posts.add(new Post(Species.MESANGE,new Profile(),new Date(),new GeoPoint(0.1,0),"post test",R.mipmap.mesange));
        posts.add(new Post(Species.MESANGE,new Profile(),new Date(),new GeoPoint(0.1,0),"post test",R.mipmap.mesange));
       posts.add((new Post()));
    }

    public static List<Post> getPosts() {
        return posts;
    }

}
