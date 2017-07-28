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

public class DetailHotelActivity extends AppCompatActivity {

    private TextView mTextDeskripsiHotel;
    private TextView mAlamatHotel;
    private ImageView imageLokasiHotel;
    private TextView mLatLangHotel;
    private ImageView mImage;
    private TextView mWebsite;
    private String mNama;
    private String mAlamat;
    private String mLat;
    private String mLang;
    private String sWebsite;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        intent = getIntent();

        mNama = intent.getStringExtra("nama");
        mAlamat = intent.getStringExtra("alamat");
        mLat = intent.getStringExtra("lat");
        mLang = intent.getStringExtra("lang");
        sWebsite = intent.getStringExtra("website");

        getSupportActionBar().setTitle(mNama);

        mTextDeskripsiHotel = (TextView) findViewById(R.id.tentang_hotel);
        mAlamatHotel = (TextView) findViewById(R.id.text_alamat_detail_hotel);
//        imageLokasiHotel = (ImageView) findViewById(R.id.img_lokasi_detail_hotel);
        mLatLangHotel = (TextView) findViewById(R.id.text_latlang_detail_hotel);
        mImage = (ImageView) findViewById(R.id.img_detail_hotel);
        mWebsite = (TextView) findViewById(R.id.text_website_detail_hotel);

        mAlamatHotel.setText("Alamat : " + mAlamat);
        mLatLangHotel.setText("LatLong : " + mLat + "," + mLang);
        mWebsite.setText("Website : "+sWebsite);

        mWebsite.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String webUrl = intent.getStringExtra("website");

                        Intent intent2 = new Intent(DetailHotelActivity.this, WebViewActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putString("website", webUrl);
                        bundle.putString("nama", mNama);

                        intent2.putExtras(bundle);
                        startActivity(intent2);

                    }
                }
        );

        mTextDeskripsiHotel.setText(intent.getStringExtra("deskripsi"));

        String sGambar = intent.getStringExtra("gambar");
        Glide.with(this)
                .load("http://palangkarayaguide.pe.hu/" + sGambar)
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(mImage);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_detail_hotel);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double lat = Double.parseDouble(mLat);
                double lng = Double.parseDouble(mLang);

                Intent intent1 = new Intent(DetailHotelActivity.this, MapsActivity.class);

                Bundle bundle = new Bundle();
                bundle.putDouble("Lat", lat);
                bundle.putDouble("Lang", lng);
                bundle.putString("nama", mNama);

                intent1.putExtras(bundle);
                startActivity(intent1);
            }
        });


//        imageLokasiHotel.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        double lat = Double.parseDouble(mLat);
//                        double lng = Double.parseDouble(mLang);
//
//                        Intent intent1 = new Intent(DetailHotelActivity.this, MapsActivity.class);
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
