package fi.jamk.aad.l3334.menuexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getBaseContext(), "Welcome to short menu example", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        try {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_main, menu);
        } catch(InflateException ie){
            return false;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_video:
                Toast.makeText(getBaseContext(), "Video", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_music:
                Toast.makeText(getBaseContext(), "Music", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_quit:
                Toast.makeText(getBaseContext(), "Quit", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
