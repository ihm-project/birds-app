package com.example.birdsapp.map.fragment;

import android.content.Intent;
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
import com.example.birdsapp.post.activity.PostActivity;

import org.osmdroid.config.Configuration;

import java.util.ArrayList;

public class ListPostFragment extends Fragment {

        ArrayList<Post> posts;

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
            posts = new ArrayList<>(PostList.getPosts());
            View rootView=inflater.inflate(R.layout.fragment_list_post,container,false);
            PostAdapter adapter = new PostAdapter(getContext(), (ArrayList<Post>) posts);
            ((ListView)rootView.findViewById(R.id.listPost)).setAdapter(adapter);

            ListView lv = rootView.findViewById(R.id.listPost);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d("ListPost",String.valueOf(PostList.getPosts().get(position).getPhoto()));
                    Intent intentPost = new Intent(getContext(), PostActivity.class);
                    intentPost.putExtra("POST",posts.get(position));
                    startActivity(intentPost);
                }
            });
            return rootView;
        }
}
