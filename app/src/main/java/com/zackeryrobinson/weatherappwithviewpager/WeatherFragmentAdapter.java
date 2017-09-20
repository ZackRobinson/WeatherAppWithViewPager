package com.zackeryrobinson.weatherappwithviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by Zack on 9/19/2017.
 */

public class WeatherFragmentAdapter extends FragmentPagerAdapter {
    private List<WeatherFragment> fragments;

    public WeatherFragmentAdapter(FragmentManager fm, List<WeatherFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
