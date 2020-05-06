package com.example.birdsapp.post.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.birdsapp.R;
import com.example.birdsapp.data.Species;
import com.example.birdsapp.map.activity.MapActivity;
import com.example.birdsapp.models.Post;
import com.example.birdsapp.post.PostListTool;
import com.example.birdsapp.profile.Profile;

import org.osmdroid.util.GeoPoint;

import java.util.Date;
import java.util.List;

public class NewPostActivity extends AppCompatActivity implements View.OnClickListener {
    PostListTool postTool = new PostListTool();
    List<Post> posts;
    Profile profile;

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
        Spinner spinner = (Spinner)findViewById(R.id.species_dropdown);
        DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker1);
        Species species = (Species)spinner.getSelectedItem();
        String description = ((EditText)findViewById(R.id.description_textInput)).getText().toString();
        Date date = new Date();
        if (button.getId() == R.id.save_post_button) {
            Post post = new Post(species, this.profile, date, new GeoPoint(0.1, 0.1), description, 0);
            postTool.addPost(post, getSharedPreferences(PostListTool.KEY, Context.MODE_PRIVATE));
            postTool.save(posts, getSharedPreferences(PostListTool.KEY, Context.MODE_PRIVATE));
            Intent intent = new Intent(getApplicationContext(), MapActivity.class);
            startActivity(intent);
        }
    }
}
