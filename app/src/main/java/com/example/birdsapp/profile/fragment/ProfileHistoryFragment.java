package com.example.birdsapp.profile.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.birdsapp.R;
import com.example.birdsapp.models.Post;
import com.example.birdsapp.models.PostAdapter;
import com.example.birdsapp.post.PostListTool;
import com.example.birdsapp.post.activity.PostActivity;

import java.util.Arrays;
import java.util.List;

public class ProfileHistoryFragment extends Fragment {
    private List<Post> posts;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.fragment_profile_history,container,false);
        posts = PostListTool.loadOwnerList(getActivity());
//        PostList.initPostList();
//        posts = PostList.getPosts();
        System.out.println(Arrays.toString(posts.toArray()));

        PostAdapter adapter = new PostAdapter(getContext(), posts);
        ((ListView)rootView.findViewById(R.id.history_profile_list)).setAdapter(adapter);

        ListView lv = rootView.findViewById(R.id.history_profile_list);
        lv.setDividerHeight(lv.getHeight()*posts.size());
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentPost = new Intent(getContext(), PostActivity.class);
                intentPost.putExtra("POST",posts.get(position));
                intentPost.putExtra("lastActivity","Profile");
                startActivity(intentPost);
            }
        });


        return rootView;
    }
}
