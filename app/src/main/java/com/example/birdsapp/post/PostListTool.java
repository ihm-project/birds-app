package com.example.birdsapp.post;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;

import com.example.birdsapp.R;
import com.example.birdsapp.data.Species;
import com.example.birdsapp.models.Post;
import com.example.birdsapp.profile.Profile;
import com.google.gson.Gson;

import org.osmdroid.util.GeoPoint;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class PostListTool {
    public final static String KEY = "postsList";

    public static List<Post> load(SharedPreferences mPrefs){
        if(!mPrefs.contains(KEY)) initPosts(mPrefs);
        Gson gson = new Gson();
        String json = mPrefs.getString(KEY, "");
        List<Post> saved = new LinkedList<>(Arrays.asList(gson.fromJson(json, Post[].class)));
        return saved;
    }

    public static List<Post> loadOwnerList(final Activity activity){
        SharedPreferences mPrefs = activity.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        if(!mPrefs.contains(KEY)) initPosts(mPrefs);
        Gson gson = new Gson();
        String json = mPrefs.getString(KEY, "");
        List<Post> saved = new LinkedList<>(Arrays.asList(gson.fromJson(json, Post[].class)));
        saved.removeIf(new Predicate<Post>() {
            @Override
            public boolean test(Post post) {
                return !post.getProfile().equals(Profile.load(activity.getSharedPreferences(Profile.SAVE_LINK, Context.MODE_PRIVATE)));
            }
        });
        return saved;
    }

    public static void save(List<Post> posts, SharedPreferences mPrefs){
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(posts);
        prefsEditor.putString(KEY, json);
        prefsEditor.commit();
    }

    public static void addPost(Post post, SharedPreferences mPrefs){
        List<Post> posts = load(mPrefs);
        posts.add(post);
        save(posts, mPrefs);
    }

    public static void delPost(Post post, Activity activity){
        SharedPreferences mPrefs = activity.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        List<Post> posts = load(mPrefs);
        posts.remove(post);
        save(posts, mPrefs);
    }

    private static void initPosts(SharedPreferences mPrefs){
        List<Post> posts = new LinkedList<>();
        posts.add(new Post(Species.MESANGE,new Profile("other 1"),new Date(),new GeoPoint(0.1,0),"post test", R.mipmap.mesange));
        posts.add(new Post(Species.MESANGE,new Profile("other 2"),new Date(),new GeoPoint(0.1,0),"post test",R.mipmap.mesange));
        posts.add(new Post(Species.MESANGE,new Profile("other 1"),new Date(),new GeoPoint(43.6265601,7.0996152),"rue de la caroute",R.mipmap.mesange));
        posts.add(new Post(Species.MESANGE,new Profile("other 3"),new Date(),new GeoPoint(43.6174848,7.1041023999999985),"post test",R.mipmap.mesange));
        save(posts, mPrefs);
    }
}
