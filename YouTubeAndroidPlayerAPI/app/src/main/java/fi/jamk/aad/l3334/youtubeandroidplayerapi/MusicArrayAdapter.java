package fi.jamk.aad.l3334.youtubeandroidplayerapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;

/**
 * Created by Krzysztof on 25.09.2017.
 */

public class MusicArrayAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> titles;
    private ArrayList<String> urls;

    public MusicArrayAdapter(Context context, ArrayList<String> urls, ArrayList<String> titles){
        super(context, R.layout.playrow, R.id.music_title, titles);
        this.titles = titles;
        this.urls = urls;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get row
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.playrow, parent, false);

        TextView textView = (TextView) row.findViewById(R.id.music_title);
        textView.setText(titles.get(position));

        try {
            YouTubeThumbnailView thumbnail = (YouTubeThumbnailView) row.findViewById(R.id.thumbnail);
            GlideApp.with(row).load("https://img.youtube.com/vi/" + urls.get(position) + "/sddefault.jpg").into(thumbnail);
        } catch(Exception e){
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return row;
    }

}
