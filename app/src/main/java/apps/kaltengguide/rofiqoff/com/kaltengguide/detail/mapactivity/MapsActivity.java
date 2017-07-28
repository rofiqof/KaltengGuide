package apps.kaltengguide.rofiqoff.com.kaltengguide.detail.mapactivity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import apps.kaltengguide.rofiqoff.com.kaltengguide.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Bundle bundle = getIntent().getExtras();

        double lat = bundle.getDouble("Lat");
        double lang = bundle.getDouble("Lang");
        String sNama = bundle.getString("nama");

//        mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lang)).title(sNama));

        goToLocationZoom(lat, lang, 15, sNama);
    }

    public boolean googleServicesAvailable() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if (isAvailable == ConnectionResult.SUCCESS) {
            return true;
        } else if (api.isUserResolvableError(isAvailable)) {
            Dialog dialog = api.getErrorDialog(this, isAvailable, 0);
            dialog.show();
        } else {
            Toast.makeText(this, "Tidak bisa konek ke google play service", Toast.LENGTH_SHORT);
        }
        return false;
    }

    private void goToLocation(double lat, double lang) {
        LatLng latLng = new LatLng(lat, lang);
        CameraUpdate update = CameraUpdateFactory.newLatLng(latLng);
        mMap.moveCamera(update);
    }

    private void goToLocationZoom(double lat, double lang, float zoom, String sNama) {
        LatLng latLng = new LatLng(lat, lang);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(latLng, zoom);

        String sLat = String.valueOf(lat);
        String sLang = String.valueOf(lang);

        mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lang)).title(sNama)).setSnippet(sLat +", "+sLang);
        mMap.moveCamera(update);
    }
}
