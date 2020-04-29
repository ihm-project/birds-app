package com.example.birdsapp.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.birdsapp.R;
import com.example.birdsapp.navigationBar.NavigationBar;
import com.example.birdsapp.profile.Profile;
import com.example.birdsapp.profile.fragment.ProfileHistoryFragment;
import com.example.birdsapp.profile.fragment.ProfileInfoFragment;
import com.example.birdsapp.tools.CameraTool;

import static com.example.birdsapp.profile.Profile.*;

public class ProfileActivity extends AppCompatActivity {
    private ProfileHistoryFragment historyFragment;
    private ProfileInfoFragment detailFragment;
    private NavigationBar navigatorFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        Profile profile = Profile.load(getSharedPreferences(Profile.SAVE_LINK, Context.MODE_PRIVATE));

        detailFragment=(ProfileInfoFragment) getSupportFragmentManager().findFragmentById(R.id.frame_profile_description);
        if(detailFragment==null){
            detailFragment = new ProfileInfoFragment();
            Bundle args= new Bundle();
            args.putAll(profile.getBundle());

            detailFragment.setArguments(args);

            transaction.replace(R.id.frame_profile_description,detailFragment);
        }

        historyFragment=(ProfileHistoryFragment) getSupportFragmentManager().findFragmentById(R.id.frame_profile_history);
        if(historyFragment==null){
            historyFragment = new ProfileHistoryFragment();
            Bundle args= new Bundle();
//            args.putAll(profile.getBundle());

            historyFragment.setArguments(args);

            transaction.replace(R.id.frame_profile_history,historyFragment);
        }

        navigatorFragment=(NavigationBar) getSupportFragmentManager().findFragmentById(R.id.frame_profile_navigator);
        if(navigatorFragment==null){
            NavigationBar navigatorFragment = new NavigationBar();
            Bundle args= new Bundle();
//            args.putAll(profile.getBundle());

            navigatorFragment.setArguments(args);

             transaction.replace(R.id.frame_profile_navigator,navigatorFragment);
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case CameraTool.REQUEST_CAMERA:
                if( grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    CameraTool.takePicture(this);
                } break;
            case CameraTool.REQUEST_WRITE_EXT_MEM:
                if( grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    this.detailFragment.saveImg();
                } break;
            case CameraTool.REQUEST_READ_EXT_MEM:
                if( grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    this.detailFragment.loadImg();
                } break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CameraTool.REQUEST_CAMERA){
            this.detailFragment.setAvatar((Bitmap)data.getExtras().get("data"));
        }
    }
}
