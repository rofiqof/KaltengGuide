package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.kotawaringinbarat.fragmenttab.map;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import apps.kaltengguide.rofiqoff.com.kaltengguide.R;
import apps.kaltengguide.rofiqoff.com.kaltengguide.database.JsonParser;
import apps.kaltengguide.rofiqoff.com.kaltengguide.database.Koneksi;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {

    MapView mMapView;
    private GoogleMap mGoogleMap;

    static final LatLng AWAL = new LatLng(-2.422900, 111.748307);
    ArrayList<HashMap<String, String>> dataMap = new ArrayList<HashMap<String, String>>();
    private ProgressDialog pDialog;
    JsonParser jParser = new JsonParser();
    Koneksi lo_Koneksi = new Koneksi();
    String isi = lo_Koneksi.isi_koneksi();
    String link_url = isi + "tampil-marker-waringin-barat.php";
    JSONArray str_json = null;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapview);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e){
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mGoogleMap = googleMap;

//                goToLocationZoom(-2.422900, 111.748307, 10);
//
//                mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(-2.422900, 111.748307)).title("Kotawaringin Barat")).setSnippet("Kotawaringin Barat");

                mGoogleMap.getUiSettings().setMyLocationButtonEnabled(true);
                mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
                mGoogleMap.getUiSettings().setCompassEnabled(true);
                mGoogleMap.getUiSettings().setMapToolbarEnabled(true);

                mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(AWAL, 15));

                mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

            }
        });

        new getListInfo().execute();

        return rootView;
    }

    private void goToLocationZoom(double lat, double lang, float zoom) {
        LatLng latLng = new LatLng(lat, lang);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(latLng, zoom);
        mGoogleMap.moveCamera(update);
    }

    private void goToLocation(double lat, double lang) {
        LatLng latLng = new LatLng(lat, lang);
        CameraUpdate update = CameraUpdateFactory.newLatLng(latLng);
        mGoogleMap.moveCamera(update);
    }

    class getListInfo extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getContext());
//            pDialog.setMessage("Menghubungkan ke server...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        protected String doInBackground(String... args) {

            JSONObject json = jParser.AmbilJson(link_url);

            try {
                str_json = json.getJSONArray("marker");

                for(int i = 0; i < str_json.length(); i++)
                {
                    JSONObject ar = str_json.getJSONObject(i);
                    HashMap<String, String> map = new HashMap<String, String>();

                    map.put("Wilayah", ar.getString("Wilayah"));
                    map.put("Nama",  ar.getString("Nama"));
                    map.put("Kategori",  ar.getString("Kategori"));
                    map.put("Lat",  ar.getString("Lat"));
                    map.put("Lang",  ar.getString("Lang"));

                    dataMap.add(map);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String file_url) {
            pDialog.dismiss();
            getActivity().runOnUiThread(new Runnable() {
                public void run() {

                    for (int i = 0; i < dataMap.size(); i++)
                    {
                        HashMap<String, String> map = new HashMap<String, String>();
                        map = dataMap.get(i);
                        LatLng POSISI = new LatLng(Double.parseDouble(map.get("Lat")),Double.parseDouble(map.get("Lang")));

                        mGoogleMap.addMarker(new MarkerOptions()
                                .position(POSISI)
                                .title(map.get("Kategori"))
                                .snippet(map.get("Nama")));

                    }
                }
            });
        }

    }

}
