package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FavouritesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the music.xml layout file
        setContentView(R.layout.music);

        //Create Array
        ArrayList <Music> music = new ArrayList<>();

        for (int i = 1; i < 6; i++) {
            music.add(new Music(R.drawable.music,"Favourite Song " + i, "Artist " + i, "3:57"));
        }
        //Display the list in the list_item.xml
        MusicListAdapter adapter =
                new MusicListAdapter(this, music);
        ListView listView = (ListView) findViewById(R.id.lists);
        listView.setAdapter(adapter);
        /** This creates the intent for the Player Screen when a song is clicked */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerIntent = new Intent(FavouritesActivity.this, PlayerActivity.class);

                // Start the new activity
                startActivity(playerIntent);
            }
        });
    }
}
