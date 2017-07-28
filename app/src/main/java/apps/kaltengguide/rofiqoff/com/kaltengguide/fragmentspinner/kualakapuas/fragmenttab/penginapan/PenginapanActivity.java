package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.kualakapuas.fragmenttab.penginapan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import apps.kaltengguide.rofiqoff.com.kaltengguide.R;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.kualakapuas.fragmenttab.hotel.HotelFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.kualakapuas.fragmenttab.penginapan.losmen.LosmenFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.kualakapuas.fragmenttab.penginapan.wisma.WismaFragment;

public class PenginapanActivity extends Fragment {

    private BottomNavigationView navigation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_penginapan, container, false);

        navigation = (BottomNavigationView) rootView.findViewById(R.id.navigation_penginapan);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Fragment fragment = new HotelFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameBottomPenginapan, fragment).commit();

        return rootView;

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment;

            switch (item.getItemId()) {
                case R.id.navigation_hotel:
                    fragment = new HotelFragment();
                    break;
                case R.id.navigation_wisma:
                    fragment = new WismaFragment();
                    break;
                case R.id.navigation_losmen:
                    fragment = new LosmenFragment();
                    break;
                default:
                    fragment = new HotelFragment();
            }

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frameBottomPenginapan, fragment).commit();

            return true;
        }

    };

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_penginapan);
//
//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//    }

}
