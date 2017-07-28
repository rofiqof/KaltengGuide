package apps.kaltengguide.rofiqoff.com.kaltengguide.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import apps.kaltengguide.rofiqoff.com.kaltengguide.R;

public class SpashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SpashActivity.this, MainActivity.class));
                finish();
            }
        }, 2000);
    }
}
