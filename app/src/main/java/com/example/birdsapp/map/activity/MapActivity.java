package com.example.birdsapp.map.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.birdsapp.R;
import com.example.birdsapp.data.BirdsList;
import com.example.birdsapp.map.fragment.MapFragment;
import com.example.birdsapp.map.fragment.MapManagerFragment;
import com.example.birdsapp.navigationBar.NavigationBar;

public class MapActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        BirdsList.initBirdsList();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction(). replace(R.id.frame_map, new MapFragment()) .commit();
            getSupportFragmentManager().beginTransaction(). replace(R.id.frame_manager_map, new MapManagerFragment()) .commit();
            getSupportFragmentManager().beginTransaction(). replace(R.id.navbar, new NavigationBar()) .commit();
        }
    }
}
