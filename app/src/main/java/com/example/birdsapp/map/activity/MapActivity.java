package com.example.birdsapp.map.activity;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.birdsapp.R;
import com.example.birdsapp.data.BirdsList;
import com.example.birdsapp.data.PostList;
import com.example.birdsapp.map.fragment.MapFragment;
import com.example.birdsapp.map.fragment.MapManagerFragment;
import com.example.birdsapp.navigationBar.NavigationBar;

import static com.example.birdsapp.map.IGPSActivity.REQUEST_CODE;

public class MapActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        BirdsList.initBirdsList();
        PostList.initPostList();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction(). replace(R.id.frame_map, new MapFragment()) .commit();
            getSupportFragmentManager().beginTransaction(). replace(R.id.frame_manager_map, new MapManagerFragment()) .commit();
            getSupportFragmentManager().beginTransaction(). replace(R.id.navbar, new NavigationBar()) .commit();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantedResults){
        switch(requestCode){
            case REQUEST_CODE:{
                if(grantedResults.length>0 && grantedResults[0]== PackageManager.PERMISSION_GRANTED){
                    Toast toast = Toast.makeText(getApplicationContext(),"location activated",Toast.LENGTH_LONG);
                    toast.show();

                }
                break;
            }
        }
    }
}
