package com.example.birdsapp.post.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.birdsapp.R;
import com.example.birdsapp.map.activity.MapActivity;
import com.example.birdsapp.models.Post;
import com.example.birdsapp.post.PostListTool;
import com.example.birdsapp.profile.activity.ProfileActivity;
import com.example.birdsapp.profile.activity.ProfileModificator;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;

public class PostFragment extends Fragment {

    TextView nomAuteur;
    TextView nomEspece;
    TextView lieu;
    TextView date;
    TextView description;
    ImageView image;
    ImageButton backBtn;
    ImageButton deleteBtn;

    public PostFragment(){}
    @Override
    public void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rV= inflater.inflate(R.layout.activity_post,container,false);
        backBtn = rV.findViewById(R.id.buttonBack);
        deleteBtn = rV.findViewById(R.id.buttonDelete);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack(getArguments().getString("lastActivity"));
            }
        });

        //TODO repmlir les cases de poste, nom auteur, date etc
        nomAuteur = (TextView)rV.findViewById(R.id.nomAuteur);
        nomEspece = (TextView)rV.findViewById(R.id.nomEspece);
        lieu = (TextView)rV.findViewById(R.id.lieuObservation);
        date = (TextView)rV.findViewById(R.id.dateDePublication);
        description = (TextView)rV.findViewById(R.id.descriptionPost);
        image = (ImageView)rV.findViewById(R.id.image_bird);
        if(getArguments()!=null){
            final Post post = getArguments().getParcelable("POST");
            Log.d("POSTFRAG", "onCreateView: "+post);
            Log.d("OKTIER", "onCreateView: "+getArguments().get("lastActivity"));
            nomAuteur.setText("Posté par : " + post.getProfile().getNames());
            nomEspece.setText("Espece : "+post.getSpecy().toString());
            lieu.setText(post.getGeoPoint().toDoubleString());
            SimpleDateFormat formater = new SimpleDateFormat("'le' dd MMMM yyyy 'à' hh:mm:ss");
            date.setText(formater.format(post.getDate()));
            description.setText(post.getDescription());
            image.setImageResource(post.getPhoto());
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PostListTool.delPost(post,getActivity());
                    goBack(getArguments().getString("lastActivity"));
                }
            });

        }
        return rV;
    }

    public void goBack(String lastActivity){
        if(lastActivity.equals("Profile")){
            Intent myIntent = new Intent(getContext(), ProfileActivity.class);
            startActivityForResult(myIntent, 0);
        }
        else{
            Intent myIntent = new Intent(getContext(), MapActivity.class);
            startActivityForResult(myIntent, 0);
        }
    }
}
