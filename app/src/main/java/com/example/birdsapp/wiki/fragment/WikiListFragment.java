package com.example.birdsapp.wiki.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.birdsapp.R;
import com.example.birdsapp.data.BirdsList;
import com.example.birdsapp.wiki.WikiArrayAdapter;

public class WikiListFragment extends Fragment {

    public WikiListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savecInstancesStates) {
        View rootView = inflater.inflate(R.layout.fragment_wiki_list, container, false);
        ArrayAdapter adapter = new WikiArrayAdapter(getContext(), BirdsList.getBirds());
        ((ListView) rootView.findViewById(R.id.wiki_list)).setAdapter(adapter);
        return rootView;
    }
}
