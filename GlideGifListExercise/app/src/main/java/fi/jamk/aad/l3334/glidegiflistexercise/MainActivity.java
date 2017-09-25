package fi.jamk.aad.l3334.glidegiflistexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ListView listview = (ListView) findViewById(R.id.list);

        String[] phones = new String[]{
                "https://git-scm.com/images/logo@2x.png",
                "https://netdna.webdesignerdepot.com/uploads/2013/07/bipolar-ball.gif",
                "https://mediaproductionpractice.files.wordpress.com/2013/12/4.gif",
                "http://i.imgur.com/rNQPM2H.gif",
                "https://pixel77.com/wp-content/uploads/2016/04/davidope.gif",
                "http://31.media.tumblr.com/59f372c683c6c614794a71f2c6a0d0b6/tumblr_mvyqakirkX1s6hdl4o1_500.gif",
                "http://i0.kym-cdn.com/photos/images/newsfeed/000/720/519/de2.gif",
                "http://37.media.tumblr.com/e1b29e053c238b1baa60713bbedfd31d/tumblr_n5fjt7CReU1txp8nwo1_500.gif",
                "http://25.media.tumblr.com/tumblr_m43jfkB0cD1qj5faro1_500.gif",
                "https://cdn.dribbble.com/users/619333/screenshots/2686050/happify_icons_ac.gif"
        };

        // add data to ArrayList
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < phones.length; ++i) {
            list.add(phones[i]);
        }



        // add data to ArrayAdapter (own custom layout)
        GifArrayAdapter adapter = new GifArrayAdapter(this, list);

        // set data to listView with adapter
        listview.setAdapter(adapter);
    }
}
