package com.example.newsapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.newsapp.fragments.EntertainmentFragment;
import com.example.newsapp.fragments.HealthFragment;
import com.example.newsapp.fragments.HomeFragment;
import com.example.newsapp.fragments.ScienceFragment;
import com.example.newsapp.fragments.SportsFragment;
import com.example.newsapp.fragments.TechnologyFragment;

public class pagerAdapter extends FragmentPagerAdapter {

    int tabCount=0;
    public pagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new HomeFragment();
            case 1:return new ScienceFragment();
            case 2:return new SportsFragment();
            case 3:return new HealthFragment();
            case 4:return new TechnologyFragment();
            case 5:return new EntertainmentFragment();
            default:return null;
        }

    }


    @Override
    public int getCount() {
        return tabCount;
    }
}
