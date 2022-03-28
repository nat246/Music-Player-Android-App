ipackage com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** This creates the Recently played songs lists */
        //Create Array
        ArrayList<Music> music = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            music.add(new Music(R.drawable.music,"Song " + i, "Artist " + i, ""));
        }

        //Display the list in the list_item.xml
        MusicListAdapter adapter =
                new MusicListAdapter(this, music);
        GridView gridView = (GridView) findViewById(R.id.recently_played);
        gridView.setAdapter(adapter);
        gridView.setAdapter(adapter);
        /** This creates the intent for the Player Screen when a song is clicked */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerIntent = new Intent(MainActivity.this, PlayerActivity.class);

                // Start the new activity
                startActivity(playerIntent);
            }
        });

        /** This creates the intent for the song library section */
        //Find the view that shows the song library category
        TextView songLibrary = (TextView) findViewById(R.id.music_library);

        // Set a click listener on that View
        songLibrary.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link LibraryActivity}
                Intent libraryIntent = new Intent(MainActivity.this, LibraryActivity.class);

                // Start the new activity
                startActivity(libraryIntent);
            }
        });

        /** This creates the intent for the favourites section */
        //Find the view the shows the favourites category
        TextView favourites = (TextView) findViewById(R.id.favourites);

        //Set a click listener on that View
        favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create a new intent to open the {@link FavouritesActivity}
                Intent favouritesIntent = new Intent(MainActivity.this, FavouritesActivity.class);

                //Start the new activity
                startActivity(favouritesIntent);
            }
        });
    }
}
