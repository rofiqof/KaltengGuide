package apps.kaltengguide.rofiqoff.com.kaltengguide.detail.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import apps.kaltengguide.rofiqoff.com.kaltengguide.R;
import apps.kaltengguide.rofiqoff.com.kaltengguide.detail.mapactivity.MapsActivity;
import apps.kaltengguide.rofiqoff.com.kaltengguide.detail.video.VideoActivity;
import apps.kaltengguide.rofiqoff.com.kaltengguide.detail.webview.WebViewActivity;

public class DetailActivity extends AppCompatActivity {

    private int position = 0;

    private TextView mTextDeskripsiWisata;
    private TextView mAlamat;
    private Toolbar toolbar;
    private ImageView imgVideo;
    private ImageView imgPlay;
    private RelativeLayout playVideo;
    private ImageView imageLokasi;
    private TextView mLatLang;
    private TextView mWebsite;
    private String mNama;

    private MediaController mediaController;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intent = getIntent();

        mNama = intent.getStringExtra("nama");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(mNama);

        imgPlay = (ImageView) findViewById(R.id.img_play);
        imgVideo = (ImageView) findViewById(R.id.img_video);
        playVideo = (RelativeLayout) findViewById(R.id.play_video);
        playVideo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String sVideoLink = intent.getStringExtra("video");

                        Intent i = new Intent(DetailActivity.this, VideoActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putString("video_link", sVideoLink);

                        i.putExtras(bundle);
                        startActivity(i);

                    }
                }
        );

        String sGambar = intent.getStringExtra("gambar");

        Glide.with(this)
                .load("http://palangkarayaguide.pe.hu/" + sGambar)
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(imgVideo);


//        imageLokasi = (ImageView) findViewById(R.id.img_location);

        mTextDeskripsiWisata = (TextView) findViewById(R.id.tentang_detail);
        mAlamat = (TextView) findViewById(R.id.text_alamat_detail);
        mLatLang = (TextView) findViewById(R.id.text_latlang_detail);
        mWebsite = (TextView) findViewById(R.id.text_website_detail);

        mAlamat.setText("Alamat : "+intent.getStringExtra("alamat"));
        mWebsite.setText("Website : "+intent.getStringExtra("website"));
        mTextDeskripsiWisata.setText(intent.getStringExtra("deskripsi"));

        mWebsite.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String webUrl = intent.getStringExtra("website");

                        Intent intent2 = new Intent(DetailActivity.this, WebViewActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putString("website", webUrl);
                        bundle.putString("nama", mNama);

                        intent2.putExtras(bundle);
                        startActivity(intent2);

                    }
                }
        );

        final String sLat = intent.getStringExtra("lat");
        final String sLang = intent.getStringExtra("lang");

        mLatLang.setText("LatLong : "+sLat+", "+sLang);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_detail);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double lat = Double.parseDouble(sLat);
                        double lang = Double.parseDouble(sLang);

                        Intent intent1 = new Intent(DetailActivity.this, MapsActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putDouble("Lat", lat);
                        bundle.putDouble("Lang", lang);
                        bundle.putString("nama", mNama);

                        intent1.putExtras(bundle);
                        startActivity(intent1);
            }
        });

//        imageLokasi.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        double lat = Double.parseDouble(sLat);
//                        double lang = Double.parseDouble(sLang);
//
//                        Intent intent1 = new Intent(DetailActivity.this, MapsActivity.class);
//
//                        Bundle bundle = new Bundle();
//                        bundle.putDouble("Lat", lat);
//                        bundle.putDouble("Lang", lang);
//                        bundle.putString("nama", mNama);
//
//                        intent1.putExtras(bundle);
//                        startActivity(intent1);
//                    }
//                }
//        );

    }
}
