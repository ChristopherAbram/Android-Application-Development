package fi.jamk.aad.l3334.mapexercise;

import android.location.Location;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Krzysztof on 09.10.2017.
 */

public class OnMapReady implements OnMapReadyCallback {

    private JSONArray positions;
    private GoogleMap gMap;

    public OnMapReady(JSONArray positions){
        this.positions = positions;
    }

    public void showMyLocation(Location location){

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        try {

            for(int i = 0; i < positions.length(); ++i) {
                JSONObject pos = positions.getJSONObject(i);

                LatLng ll = new LatLng(pos.getDouble("lat"), pos.getDouble("lng"));
                googleMap.addMarker(new MarkerOptions().position(ll).title(pos.getString("title")));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(ll));
            }

        } catch(JSONException je){
            Log.e("JSON", "Error getting data.");
        }
    }
}
