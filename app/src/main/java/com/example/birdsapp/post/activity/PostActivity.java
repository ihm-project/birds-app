package com.example.birdsapp.post.activity;

import android.os.Bundle;

import com.example.birdsapp.R;
import com.example.birdsapp.post.fragment.PostFragment;

import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_post);
        getSupportFragmentManager().beginTransaction().replace(R.id.page_post, new PostFragment()).commit();
    }
}
