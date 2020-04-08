package com.example.birdsapp.map.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.birdsapp.R;
import com.example.birdsapp.map.activity.OSMActivity;


public class MapManagerFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.fragment_list_map,container,false);
        rootView.findViewById(R.id.buttonStartMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getContext(), OSMActivity.class);
                startActivity( intent );
            }
        });
        return rootView;
    }
}
