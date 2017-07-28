package apps.kaltengguide.rofiqoff.com.kaltengguide.detail.video;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import apps.kaltengguide.rofiqoff.com.kaltengguide.R;

public class VideoActivity extends AppCompatActivity {

    private VideoView mVideoView;
    private MediaController mMediaController;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Video");

        mVideoView = (VideoView) findViewById(R.id.video_view);

        Bundle bundle = getIntent().getExtras();
        String sLink = bundle.getString("video_link");
        String videourl = "http://palangkarayaguide.pe.hu/"+sLink;

        progressDialog = new ProgressDialog(VideoActivity.this);
        progressDialog.setTitle("Video");
        progressDialog.setMessage("Loading...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true);
        progressDialog.show();

        try {
            MediaController mediacontroller = new MediaController(
                    VideoActivity.this);
            mediacontroller.setAnchorView(mVideoView);
            Uri video = Uri.parse(videourl);
            mVideoView.setMediaController(mediacontroller);
            mVideoView.setVideoURI(video);

        } catch (Exception e) {
            progressDialog.dismiss();
            Log.e("Error", e.getMessage());
            e.printStackTrace();
            finish();
        }

//        progressDialog.dismiss();

        mVideoView.requestFocus();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
                progressDialog.dismiss();
                mVideoView.start();
            }
        });

    }

}
