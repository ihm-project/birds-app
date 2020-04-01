package com.example.birdsapp.map.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.birdsapp.R;
import com.example.birdsapp.map.fragment.List_MapFragment;
import com.example.birdsapp.map.fragment.MapFragment;
import com.example.birdsapp.navigationBar.NavigationBar;

public class MapActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction(). replace(R.id.frame_map, new MapFragment()) .commit();
            getSupportFragmentManager().beginTransaction(). replace(R.id.frame_menu_list_map, new List_MapFragment()) .commit();
            getSupportFragmentManager().beginTransaction(). replace(R.id.navbar, new NavigationBar()) .commit();

        }


    }
}
