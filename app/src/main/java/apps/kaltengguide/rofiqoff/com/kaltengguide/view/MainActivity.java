package apps.kaltengguide.rofiqoff.com.kaltengguide.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

import apps.kaltengguide.rofiqoff.com.kaltengguide.R;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.bandara.BandaraFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.barito.TabLayoutBaritoFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.gunungmas.TabLayoutGunungMasFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.katingan.TabLayoutKatinganFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.kotawaringinbarat.TabLayoutWaringinBaratFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.kotawaringintimur.TabLayoutKotaWaringinTimurFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.kualakapuas.TabLayoutKualaKapuasFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.lamnadau.TabLayoutLamnadauFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.palangkaraya.TabLayoutPalangkarayaFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.pulangpisau.TabLayoutPulangPisauFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.seruyan.TabLayoutSeruyanFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Setup spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new MyAdapter(
                toolbar.getContext(),
                new String[]{
                        "Kotawaringin Barat",
                        "Kotawaringin Timur",
                        "Seruyan",
                        "Kabupaten Katingan",
                        "Palangkaraya",
                        "Kabupaten Gunung Mas",
                        "Kabupaten Lamandau",
                        "Kabupaten Barito",
                        "Kabupaten Kuala Kapuas",
                        "Kabupaten Pulang Pisau",
                }));

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // When the given dropdown item is selected, show its contents in the
                // container view.

                Fragment fragmentSippner = null;
                Class fragmentClass = null;

                switch (position) {
                    case 0:
                        fragmentSippner = new TabLayoutWaringinBaratFragment();
                        break;
                    case 1:
                        fragmentSippner = new TabLayoutKotaWaringinTimurFragment();
                        break;
                    case 2:
                        fragmentSippner = new TabLayoutSeruyanFragment();
                        break;
                    case 3:
                        fragmentSippner = new TabLayoutKatinganFragment();
                        break;
                    case 4:
                        fragmentSippner = new TabLayoutPalangkarayaFragment();
                        break;
                    case 5:
                        fragmentSippner = new TabLayoutGunungMasFragment();
                        break;
                    case 6:
                        fragmentSippner = new TabLayoutLamnadauFragment();
                        break;
                    case 7:
                        fragmentSippner = new TabLayoutBaritoFragment();
                        break;
                    case 8:
                        fragmentSippner = new TabLayoutKualaKapuasFragment();
                        break;
                    case 9:
                        fragmentSippner = new TabLayoutPulangPisauFragment();
                        break;
                    default:
                        break;
                }

                try {
                    fragmentSippner = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_spinner, fragmentSippner)
                        .commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Fragment fragment = new TabLayoutWaringinBaratFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container_spinner, fragment)
                        .commit();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (item.getItemId()){
            case R.id.action_tentang:
                startActivity(new Intent(MainActivity.this, TentangActivity.class));
                return true;

            case R.id.action_masukan:
                startActivity(new Intent(MainActivity.this, KomentarPenilaian.class));
                return true;

            case R.id.action_bandara:
                Fragment fragment = new BandaraFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container_spinner, fragment)
                        .commit();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}