package fi.jamk.aad.l3334.glidegiflistexercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Krzysztof on 25.09.2017.
 */

public class GifArrayAdapter extends ArrayAdapter<String> {
    // application conntext
    private Context context;
    // phone data (names)
    private ArrayList<String> links;

    public GifArrayAdapter(Context context, ArrayList<String> links){
        super(context, R.layout.item, R.id.link, links);
        this.context = context;
        this.links = links;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.item, parent, false);

        TextView link = (TextView) row.findViewById(R.id.link);
        link.setText(links.get(position));

        ImageView image = (ImageView) row.findViewById(R.id.image);
        try {
            GlideApp.with(row).load(links.get(position)).into(image);
        } catch(Exception e){
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return row;
    }

}
