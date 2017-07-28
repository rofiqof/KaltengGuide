package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.bandara;


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
public class BandaraFragment extends Fragment {

    private SectionPagerAdapterBandara sectionPagerAdapterBandara;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    public BandaraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_bandara, container, false);

        sectionPagerAdapterBandara = new SectionPagerAdapterBandara(getFragmentManager());

        viewPager = (ViewPager) rootView.findViewById(R.id.container_bandara);
        viewPager.setAdapter(sectionPagerAdapterBandara);

        tabLayout = (TabLayout) rootView.findViewById(R.id.tab_bandara);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(android.R.color.white));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }

}
