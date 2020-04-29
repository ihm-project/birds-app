package com.example.birdsapp.post;

import android.content.SharedPreferences;

import com.example.birdsapp.models.Post;
import com.example.birdsapp.profile.Profile;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PostListTool {
    public final static String KEY = "postsList";

    public static List<Post> load(SharedPreferences mPrefs){
        Gson gson = new Gson();
        String json = mPrefs.getString(KEY, "");
        List<Post> saved = new LinkedList<>(Arrays.asList(gson.fromJson(json, Post[].class)));
        return saved;
    }

    public static List<Post> loadOwnerList(SharedPreferences mPrefs){
        Gson gson = new Gson();
        String json = mPrefs.getString(KEY, "");
        List<Post> saved = new LinkedList<>(Arrays.asList(gson.fromJson(json, Post[].class)));
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
}
