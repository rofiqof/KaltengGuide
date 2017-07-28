package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.bandara;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.bandara.fragmentab.asan.AsanFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.bandara.fragmentab.beringin.BeringinFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.bandara.fragmentab.iskandar.IskandarFragment;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.bandara.fragmentab.tjilikriwut.TjilikRiwutFragment;

/**
 * Created by rofiqoff on 4/27/17.
 */

public class SectionPagerAdapterBandara extends FragmentPagerAdapter {

    String tittle[] = new String[]{
      "Bandara Iskandar", "Bandara H Asan", "Bandara Tjilik Riwut Baru", "Bandara Beringin"
    };

    public SectionPagerAdapterBandara(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment  =null;
        switch (position){
            case 0:
                fragment = new IskandarFragment();
                break;
            case 1:
                fragment = new AsanFragment();
                break;
            case 2:
                fragment = new TjilikRiwutFragment();
                break;
            case 3:
                fragment = new BeringinFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tittle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tittle[position];
    }

}
