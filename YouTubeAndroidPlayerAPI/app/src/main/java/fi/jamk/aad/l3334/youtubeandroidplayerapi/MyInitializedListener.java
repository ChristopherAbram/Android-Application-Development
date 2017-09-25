package fi.jamk.aad.l3334.youtubeandroidplayerapi;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;

/**
 * Created by Krzysztof on 25.09.2017.
 */

public class MyInitializedListener implements OnInitializedListener {

    private YouTubePlayer youTubePlayer;

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        this.youTubePlayer = youTubePlayer;
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    public void play(final String id){
        if(youTubePlayer != null)
            youTubePlayer.loadVideo(id);
    }
}
