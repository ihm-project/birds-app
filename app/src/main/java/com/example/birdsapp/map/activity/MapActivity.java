package com.example.birdsapp.map.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.birdsapp.R;
import com.example.birdsapp.map.fragment.MapFragment;

public class MapActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        MapFragment mainFragment=(MapFragment) getSupportFragmentManager().findFragmentById(R.id.frame_map);
        if(mainFragment==null){
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_map,new MapFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
