package com.example.birdsapp.map.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import com.example.birdsapp.R;
import com.example.birdsapp.data.BirdsList;
import com.example.birdsapp.data.PostList;
import com.example.birdsapp.models.Post;
import com.example.birdsapp.models.PostAdapter;

import org.osmdroid.config.Configuration;

import java.util.ArrayList;

public class ListPostFragment extends Fragment {


        public ListPostFragment(){

        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Configuration.getInstance().load(   getContext(),
                    PreferenceManager.getDefaultSharedPreferences(getContext()) );
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            View rootView=inflater.inflate(R.layout.fragment_list_post,container,false);
            PostAdapter adapter = new PostAdapter(getContext(), (ArrayList<Post>) PostList.getPosts());
            ((ListView)rootView.findViewById(R.id.listPost)).setAdapter(adapter);

            ListView lv = rootView.findViewById(R.id.listPost);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d("ListPost",String.valueOf(PostList.getPosts().get(position).getPhoto()));


                }
            });
            return rootView;
        }
}
