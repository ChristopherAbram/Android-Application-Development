package fi.jamk.aad.l3334.youtubeandroidplayerapi;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class MainActivity extends YouTubeBaseActivity {

    private YouTubePlayerView youTubePlayerView;
    private MyInitializedListener onInitializedListener;

    // Dummy data here:
    private final String[] music = new String[]{
            "uuZE_IRwLNI", "Justin Timberlake - Mirrors",
            "XbGs_qK2PQA", "Eminem - Rap God (Explicit)",
            "-f57lF0pKSA", "Harley Quinn & The Joker - High As Me",
            "kF9ijspj3l4", "Ben Howard - Time Is Dancing"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.you_tube);
        onInitializedListener = createInitializedListiner();
        youTubePlayerView.initialize("AIzaSyB0Z0t-bhysIdWz8EaeVfQ_qrtnuya_wQ4", onInitializedListener);

        ListView playListView = (ListView) findViewById(R.id.playlist);
        MusicArrayAdapter adapter = new MusicArrayAdapter(this, getMusicIds(), getMusicTitles());
        playListView.setAdapter(adapter);
        playListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onInitializedListener.play(music[2*i]);
                Toast.makeText(getBaseContext(), "Number: " + i, Toast.LENGTH_LONG).show();
                return;
            }
        });


    }

    private ArrayList<String> getMusicIds(){
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < music.length; i+=2){
            list.add(music[i]);
        }
        return list;
    }

    private ArrayList<String> getMusicTitles(){
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < music.length; i+=2){
            list.add(music[i + 1]);
        }
        return list;
    }

    private MyInitializedListener createInitializedListiner(){
        return new MyInitializedListener();
    }
}
