package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.newsapp.adapter.pagerAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    String api="f92b6fcda30540a9ab30f99e0758fe1d";
    Toolbar mToolbar;
    PagerAdapter mpagerAdapter;
    TabItem mScience,mHome,mHealth,mSports,mEntertainment,mTechnology;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar=findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);
        mScience=findViewById(R.id.scienceTab);
        mHome=findViewById(R.id.homeTab);
        mHealth=findViewById(R.id.healthTab);
        mSports=findViewById(R.id.sportsTab);
        mEntertainment=findViewById(R.id.entertainmentTab);
        mTechnology=findViewById(R.id.techTab);

        tabLayout=findViewById(R.id.include);
        ViewPager mViewPager=findViewById(R.id.fragmentContainer);
         mpagerAdapter= new pagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
         mViewPager.setAdapter(mpagerAdapter);

         tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
             @Override
             public void onTabSelected(TabLayout.Tab tab) {

                 mViewPager.setCurrentItem(tab.getPosition());
                     mpagerAdapter.notifyDataSetChanged();
             }

             @Override
             public void onTabUnselected(TabLayout.Tab tab) {

             }

             @Override
             public void onTabReselected(TabLayout.Tab tab) {

             }
         });
         mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

         }
    }