package com.example.birdsapp.profile.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.birdsapp.R;
import com.example.birdsapp.map.activity.MapActivity;
import com.example.birdsapp.profile.activity.ProfileModificator;

import static com.example.birdsapp.profile.Profile.*;

public class ProfileInfoFragment extends Fragment {

    private String names;
    private String title;
    private String country;
    private String descript;
    private int image;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            names=getArguments().getString(NAMES_KEY);
            descript=getArguments().getString(DESC_KEY);
            image=getArguments().getInt(IMG_KEY);
            country=getArguments().getString(COUNTRY_KEY);
            title=getArguments().getString(TITLE_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView= inflater.inflate(R.layout.fragment_profile_description,container,false);

        rootView.findViewById(R.id.modif_profile_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMap = new Intent(getContext(), ProfileModificator.class);
                startActivity(intentMap);
            }
        });

        TextView nameView = (TextView) rootView.findViewById(R.id.profileNamesTextView);
        nameView.setText(names);

        TextView titleView = (TextView) rootView.findViewById(R.id.profileTitleTextView);
        titleView.setText(title);


        TextView countryView = (TextView) rootView.findViewById(R.id.profileCountryTextView);
        countryView.setText(country);


        TextView commentView = (TextView) rootView.findViewById(R.id.profileDescriptionSlotTextView);
        commentView.setText(descript);

        ImageView imageView = rootView.findViewById(R.id.profileAvatarImg);
        imageView.setImageResource(image);
        return rootView;
    }
}
