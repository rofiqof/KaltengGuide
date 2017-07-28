package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.katingan;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import apps.kaltengguide.rofiqoff.com.kaltengguide.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabLayoutKatinganFragment extends Fragment {

    private SectionsPagerAdapterKatingan mSectionPagerAdapter;
    private ViewPager mViewPager;

    public TabLayoutKatinganFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_tab_layout_katingan, container, false);
        mSectionPagerAdapter = new SectionsPagerAdapterKatingan(getFragmentManager());

        mViewPager = (ViewPager) rootView.findViewById(R.id.container_Tab_katingan);
        mViewPager.setAdapter(mSectionPagerAdapter);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabs_katingan);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(android.R.color.white));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(mViewPager);

        return rootView;
    }

}
