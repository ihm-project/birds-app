package com.example.birdsapp.wiki.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.birdsapp.R;

public class WikiTopFragment extends Fragment {

    public WikiTopFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savecInstancesStates) {
        return inflater.inflate(R.layout.fragment_wiki_top, container, false);
    }
}
