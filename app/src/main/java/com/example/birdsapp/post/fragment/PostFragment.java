package com.example.birdsapp.post.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.birdsapp.R;

import androidx.fragment.app.Fragment;

public class PostFragment extends Fragment {

    public PostFragment(){}
    @Override
    public void onCreate(Bundle savedInstantState) {
        super.onCreate(savedInstantState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rV= inflater.inflate(R.layout.activity_post,container,false);
        //TODO repmlir les cases de poste, nom auteur, date etc
        final TextView nomAuteur = (TextView)rV.findViewById(R.id.nomAuteur);
        final TextView nomEspece = (TextView)rV.findViewById(R.id.nomEspece);
        final TextView lieu = (TextView)rV.findViewById(R.id.lieuObservation);
        final TextView date = (TextView)rV.findViewById(R.id.dateDePublication);
        final TextView description = (TextView)rV.findViewById(R.id.descriptionPost);
        
        return rV;
    }
}
