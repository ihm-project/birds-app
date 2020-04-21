package com.example.birdsapp.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.birdsapp.R;

import java.util.ArrayList;

public class PostAdapter extends ArrayAdapter<Post> {
        public PostAdapter(Context context, ArrayList<Post> posts) {
            super(context, 0, posts);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Post post = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_post, parent, false);
            }
            ImageView img = (ImageView)  convertView.findViewById(R.id.imgSpecy);
            TextView specy = (TextView) convertView.findViewById(R.id.nameSpecy);
            TextView name = (TextView) convertView.findViewById(R.id.nameProfile);
            specy.setText(post.specy.toString());
            name.setText("par "+post.profile.getNames());
            img.setImageResource(post.photo);
            return convertView;
        }
    }


