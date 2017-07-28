package apps.kaltengguide.rofiqoff.com.kaltengguide.detail.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import apps.kaltengguide.rofiqoff.com.kaltengguide.R;
import apps.kaltengguide.rofiqoff.com.kaltengguide.detail.mapactivity.MapsActivity;
import apps.kaltengguide.rofiqoff.com.kaltengguide.detail.webview.WebViewActivity;

public class DetailTravelActivity extends AppCompatActivity {

    private TextView mTextDeskripsiTravel;
    private TextView mAlamatTravel;
    private ImageView imageLokasiTravel;
    private TextView mLatLangTravel;
    private TextView mNamaTravel;
    private TextView mWebsite;
    private ImageView mImage;
    private String mNama;
    private String mAlamat;
    private String mLat;
    private String mLang;
    private String sWebsite;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_travel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        intent = getIntent();

        mNama = intent.getStringExtra("nama");
        mAlamat = intent.getStringExtra("alamat");
        sWebsite = intent.getStringExtra("website");
        mLat = intent.getStringExtra("lat");
        mLang = intent.getStringExtra("lang");

        getSupportActionBar().setTitle(mNama);

        mTextDeskripsiTravel = (TextView) findViewById(R.id.tentang_travel);
        mAlamatTravel = (TextView) findViewById(R.id.text_alamat_detail_travel);
//        mNamaTravel = (TextView) findViewById(R.id.text_nama_travel);
//        imageLokasiTravel = (ImageView) findViewById(R.id.img_lokasi_detail_travel);
        mLatLangTravel = (TextView) findViewById(R.id.text_latlang_detail_travel);
        mImage = (ImageView) findViewById(R.id.gambar_travel_detail);
        mWebsite = (TextView) findViewById(R.id.text_website_detail_travel);

//        mNamaTravel.setText(mNama);
        mAlamatTravel.setText("Alamat : " +mAlamat);
        mLatLangTravel.setText("LatLong : " + mLat+ "," +mLang);
        mWebsite.setText("Website : "+sWebsite);

        mWebsite.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String webUrl = intent.getStringExtra("website");

                        Intent intent2 = new Intent(DetailTravelActivity.this, WebViewActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putString("website", webUrl);
                        bundle.putString("nama", mNama);

                        intent2.putExtras(bundle);
                        startActivity(intent2);

                    }
                }
        );


        mTextDeskripsiTravel.setText(intent.getStringExtra("deskripsi"));

        String sGambar = intent.getStringExtra("gambar");
        Glide.with(this)
                .load("http://palangkarayaguide.pe.hu/" + sGambar)
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(mImage);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_detail_travel);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double lat = Double.parseDouble(mLat);
                double lng = Double.parseDouble(mLang);

                Intent intent1 = new Intent(DetailTravelActivity.this, MapsActivity.class);

                Bundle bundle = new Bundle();
                bundle.putDouble("Lat", lat);
                bundle.putDouble("Lang", lng);
                bundle.putString("nama", mNama);

                intent1.putExtras(bundle);
                startActivity(intent1);
            }
        });

//        imageLokasiTravel.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        double lat = Double.parseDouble(mLat);
//                        double lng = Double.parseDouble(mLang);
//
//                        Intent intent1 = new Intent(DetailTravelActivity.this, MapsActivity.class);
//
//                        Bundle bundle = new Bundle();
//                        bundle.putDouble("Lat", lat);
//                        bundle.putDouble("Lang", lng);
//                        bundle.putString("nama", mNama);
//
//                        intent1.putExtras(bundle);
//                        startActivity(intent1);
//
//                    }
//                }
//        );

    }
}
