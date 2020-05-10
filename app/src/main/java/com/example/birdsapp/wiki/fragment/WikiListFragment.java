package com.example.birdsapp.wiki.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.birdsapp.R;
import com.example.birdsapp.data.BirdsList;
import com.example.birdsapp.models.Bird;
import com.example.birdsapp.web_view.WebViewActivity;
import com.example.birdsapp.wiki.WikiArrayAdapter;

public class WikiListFragment extends Fragment {

    public WikiListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savecInstancesStates) {
        View rootView = inflater.inflate(R.layout.fragment_wiki_list, container, false);
        ArrayAdapter adapter = new WikiArrayAdapter(getContext(), BirdsList.getBirds());
        ListView listView = rootView.findViewById(R.id.wiki_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bird bird = BirdsList.getBirds().get(position);
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra(WebViewActivity.URL_KEY, bird.getUrl());
                startActivity(intent);
            }
        });
        return rootView;
    }
}
