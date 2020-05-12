package com.example.birdsapp.post.activity;

import android.os.Bundle;
import android.util.Log;

import com.example.birdsapp.R;
import com.example.birdsapp.models.Post;
import com.example.birdsapp.post.fragment.PostFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class PostActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_post);
        Post value;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            value = bundle.getParcelable("POST");
            Log.d("POST", "onCreate: "+value);
            Fragment frag = new PostFragment();
            Bundle args= new Bundle();
            args.putString("lastActivity",bundle.getString("lastActivity"));
            args.putParcelable("POST",value);
            frag.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.page_post,frag).commit();
        }
    }
}
