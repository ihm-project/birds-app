package com.example.birdsapp.wiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.birdsapp.R;
import com.example.birdsapp.navigationBar.NavigationBar;
import com.example.birdsapp.wiki.fragment.WikiListFragment;
import com.example.birdsapp.wiki.fragment.WikiTopFragment;

public class WikiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki);

        if ( savedInstanceState == null ) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_wiki_top, new WikiTopFragment()).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_wiki_list, new WikiListFragment()).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.navbar, new NavigationBar()).commit();
        }
    }
}
