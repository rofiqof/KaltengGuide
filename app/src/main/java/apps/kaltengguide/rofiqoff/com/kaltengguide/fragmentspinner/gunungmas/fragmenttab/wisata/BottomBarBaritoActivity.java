package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.gunungmas.fragmenttab.wisata;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import apps.kaltengguide.rofiqoff.com.kaltengguide.R;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.gunungmas.fragmenttab.wisata.wisataalam.WisataAlamFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.gunungmas.fragmenttab.wisata.wisatabelanja.WisataBelanjaFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.gunungmas.fragmenttab.wisata.wisatabudaya.WisataBudayaFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.gunungmas.fragmenttab.wisata.wisatakuliner.WisataKulinerFragment;

public class BottomBarBaritoActivity extends Fragment {
    private BottomNavigationView navigation;

    private TextView mTextMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_bottom_bar_barito, container, false);

        navigation = (BottomNavigationView) rootView.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Fragment fragment = new WisataAlamFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameBottom, fragment).commit();

        return rootView;

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;

            switch (item.getItemId()) {
                case R.id.navigation_wisata_alam:
                    fragment = new WisataAlamFragment();
                    break;
                case R.id.navigation_wisata_kuliner:
                    fragment = new WisataKulinerFragment();
                    break;
                case R.id.navigation_wisata_budaya:
                    fragment = new WisataBudayaFragment();
                    break;
                case R.id.navigation_wisata_belaja:
                    fragment = new WisataBelanjaFragment();
                    break;
                default:
                    fragment = new WisataAlamFragment();
            }

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frameBottom, fragment).commit();

            return true;
        }

    };

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_bottom_bar_barito);
//
//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//    }

}
