package com.example.birdsapp.post.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.birdsapp.R;
import com.example.birdsapp.data.Species;
import com.example.birdsapp.post.PostListTool;

public class NewPostActivity extends AppCompatActivity implements View.OnClickListener {
    PostListTool postTool = new PostListTool();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        Spinner spinner = (Spinner) findViewById(R.id.species_dropdown);
        spinner.setAdapter(new ArrayAdapter<Species>(this, android.R.layout.simple_spinner_item, Species.values()));

        findViewById(R.id.save_post_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View button) {

    }
}
