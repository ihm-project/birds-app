package com.example.birdsapp.wiki.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.birdsapp.R;

import java.util.ArrayList;

public class WikiListFragment extends Fragment {

    public WikiListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savecInstancesStates) {
        View rootView = inflater.inflate(R.layout.fragment_wiki_list, container, false);
        ArrayList arrayList = new ArrayList();
        for (int i = 1 ; i <= 20; i++)
            arrayList.add(i);
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, arrayList);
        ((ListView) rootView.findViewById(R.id.wiki_list)).setAdapter(adapter);
        return rootView;
    }
}
