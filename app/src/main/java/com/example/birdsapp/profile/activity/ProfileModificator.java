package com.example.birdsapp.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.birdsapp.R;
import com.example.birdsapp.map.activity.MapActivity;
import com.example.birdsapp.profile.Profile;
import com.example.birdsapp.wiki.activity.WikiActivity;

public class ProfileModificator extends AppCompatActivity implements View.OnClickListener {
    private Profile profile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_modificator);

        profile = Profile.load(getSharedPreferences(Profile.SAVE_LINK, Context.MODE_PRIVATE));
        setPreSelection();

        findViewById(R.id.save_button).setOnClickListener(this);
    }

    void setPreSelection(){

    }

    public void onClick(View button) {
        if (button.getId() == R.id.save_button) {
            save();
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
        }
    }

    private void save() {
        profile.setNames(((EditText)findViewById(R.id.name_textInput)).getText().toString());
        profile.setCountry(((EditText)findViewById(R.id.country_textInput)).getText().toString());
        profile.setDescript(((EditText)findViewById(R.id.desc_textInput)).getText().toString());
        profile.save(getSharedPreferences(Profile.SAVE_LINK, Context.MODE_PRIVATE));
    }
}
