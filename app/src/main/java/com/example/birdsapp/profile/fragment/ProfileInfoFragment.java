package com.example.birdsapp.profile.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.example.birdsapp.profile.Profile;
import com.example.birdsapp.profile.activity.ProfileModificator;
import com.example.birdsapp.tools.CameraTool;
import com.example.birdsapp.tools.ToDoAfter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Objects;

import static com.example.birdsapp.profile.Profile.*;

public class ProfileInfoFragment extends Fragment {

    private String names;
    private String title;
    private String country;
    private String descript;
    private Bitmap image;

    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            names=getArguments().getString(NAMES_KEY);
            descript=getArguments().getString(DESC_KEY);
            image = BitmapFactory.decodeResource(getResources(),R.drawable.person);
            CameraTool.read_memory(getContext(), getActivity(), new ToDoAfter() {
                @Override
                public void toDo() {
                    loadImg();
                }
            });
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

        rootView.findViewById(R.id.profileImgChangeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CameraTool.use_camera(getContext(),getActivity());
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

        imageView = rootView.findViewById(R.id.profileAvatarImg);
        imageView.setImageBitmap(image);
        return rootView;
    }

    public void setAvatar(Bitmap data) {
        image = data;
        imageView.setImageBitmap(data);
        final Profile p = Profile.load(Objects.requireNonNull(getActivity()).getSharedPreferences(Profile.SAVE_LINK, Context.MODE_PRIVATE));
        try {
            Profile.saveImg(data);
            p.setImage(SAVE_LINK);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error when img saved");
            p.setImage(NO_IMG);
        }
        saveImg();
    }

    public void saveImg(){
        CameraTool.write_memory(getContext(), getActivity(), new ToDoAfter() {
            @Override
            public void toDo() {
                 try {
                     Profile.saveImg(image);
                 }
                 catch (IOException e) {
                     e.printStackTrace();
                 }
            }
        });
    }

    public void loadImg(){
        image= Profile.loadImg();
    }
}
