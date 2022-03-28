package com.example.android.musicalstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicListAdapter extends ArrayAdapter<Music> {

    public MusicListAdapter(Activity context, ArrayList<Music> music){
        super(context, 0, music);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Gets the data for this position
        Music music = getItem(position);

        //Checks if an existing view is being reused, otherwise inflate a new view from a custom row layout
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        /**
         * 1. Find the ImageView and TextView in the list_item.xml layout using the ID
         * 2. Set the text
         */
        //Image
        ImageView musicImageView = (ImageView) listItemView.findViewById(R.id.song_icon);
        musicImageView.setImageResource(music.getImage());
        //Music Name
        TextView musicNameTextView = (TextView) listItemView.findViewById(R.id.music_name);
        musicNameTextView.setText(music.getTitle());
        //Artist's Name
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_name);
        artistTextView.setText(music.getHeading1());
        //Music Duration
        TextView durationTextView = (TextView) listItemView.findViewById(R.id.music_duration);
        durationTextView.setText(music.getHeading2());

        //Return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }
}
