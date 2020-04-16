package com.example.birdsapp.profile.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.birdsapp.R;
import com.example.birdsapp.navigationBar.NavigationBar;
import com.example.birdsapp.profile.Profile;
import com.example.birdsapp.profile.fragment.ProfileHistoryFragment;
import com.example.birdsapp.profile.fragment.ProfileInfoFragment;

import static com.example.birdsapp.profile.Profile.*;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Profile profile = Profile.load(getSharedPreferences(Profile.SAVE_LINK, Context.MODE_PRIVATE));

        ProfileInfoFragment detailFragment=(ProfileInfoFragment) getSupportFragmentManager().findFragmentById(R.id.frame_profile_description);
        if(detailFragment==null){
            Fragment frag = new ProfileInfoFragment();
            Bundle args= new Bundle();
            args.putAll(profile.getBundle());

            frag.setArguments(args);

            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_profile_description,frag);
            transaction.addToBackStack(null);
            transaction.commit();
        }

        ProfileInfoFragment historyFragment=(ProfileInfoFragment) getSupportFragmentManager().findFragmentById(R.id.frame_profile_history);
        if(historyFragment==null){
            Fragment frag = new ProfileHistoryFragment();
            Bundle args= new Bundle();
//            args.putAll(profile.getBundle());

            frag.setArguments(args);

            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_profile_history,frag);
            transaction.addToBackStack(null);
            transaction.commit();
        }

        ProfileInfoFragment navigatorFragment=(ProfileInfoFragment) getSupportFragmentManager().findFragmentById(R.id.frame_profile_history);
        if(navigatorFragment==null){
            Fragment frag = new NavigationBar();
            Bundle args= new Bundle();
//            args.putAll(profile.getBundle());

            frag.setArguments(args);

            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_profile_navigator,frag);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
