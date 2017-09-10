package fi.jamk.aad.l3334.lunchmapexcercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showOnMap(View view){
        try {
            EditText lat = (EditText)findViewById(R.id.latitude);
            EditText lng = (EditText)findViewById(R.id.latitude);

            double latitude = Double.parseDouble(lat.getText().toString());
            double longitude = Double.parseDouble(lng.getText().toString());

            if((latitude < -90.0 || latitude > 90.0) || (longitude < -180.0 || longitude > 180.0)){
                Toast.makeText(getApplicationContext(), "Wrong Latitude or Longitude given.", Toast.LENGTH_LONG).show();
                return;
            }

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:"+latitude+","+longitude));
            startActivity(intent);

        } catch(Exception e){}
        return;
    }
}
