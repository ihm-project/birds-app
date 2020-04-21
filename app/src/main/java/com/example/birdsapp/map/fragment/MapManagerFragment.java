package com.example.birdsapp.map.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.birdsapp.R;


public class MapManagerFragment extends Fragment {

    boolean displayMap=true;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View rootView=inflater.inflate(R.layout.fragment_list_map,container,false);
        rootView.findViewById(R.id.buttonStartMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = getActivity().findViewById(R.id.buttonStartMenu);

                if(displayMap) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_map, new ListPostFragment()).commit();
                    displayMap=!displayMap;
                     button.setText("Afficher la Carte");
                }
                else{
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_map, new MapFragment()).commit();
                    displayMap=!displayMap;
                    button.setText("Afficher la liste des publications");

                }

            }
        });
        return rootView;
    }
}
