package com.example.birdsapp.navigationBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.birdsapp.R;
import com.example.birdsapp.map.activity.MapActivity;
import com.example.birdsapp.profile.activity.ProfileActivity;
import com.example.birdsapp.wiki.activity.WikiActivity;

import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.Fragment;

public class NavigationBar extends Fragment implements View.OnClickListener {

    public NavigationBar() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.navigation_bar, container, false);
        rootView.findViewById(R.id.profile_button).setOnClickListener(this);
        rootView.findViewById(R.id.map_button).setOnClickListener(this);
        rootView.findViewById(R.id.wiki_button).setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View button) {
        if (button.getId() == R.id.profile_button) {
            Intent intentProfile = new Intent(getContext(), ProfileActivity.class);
            startActivity(intentProfile);
        }
        if (button.getId() == R.id.map_button) {
            Intent intentMap = new Intent(getContext(), MapActivity.class);
            startActivity(intentMap);
        }
        if (button.getId() == R.id.wiki_button) {
            Intent intentWiki = new Intent(getContext(), WikiActivity.class);
            startActivity(intentWiki);
        }
    }
}
