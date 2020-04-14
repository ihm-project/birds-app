package com.example.birdsapp.wiki;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.birdsapp.R;
import com.example.birdsapp.data.Bird;

import java.util.List;

public class WikiArrayAdapter extends ArrayAdapter {

    private final Context context;
    private final List<Bird> birdList;

    public WikiArrayAdapter(Context context, List<Bird> birdsList) {
        super(context, -1, birdsList);
        this.context = context;
        this.birdList = birdsList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.wiki_row_layout, parent, false);
        Bird bird = birdList.get(position);
        ((TextView) rowView.findViewById(R.id.species_wiki)).setText(bird.getSpecies().toString());
        if (bird.getPicture() != 0) {
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), bird.getPicture());
            ((ImageView) rowView.findViewById(R.id.image_bird_wiki)).setImageBitmap(bitmap);
        }
        return rowView;
    }
}
