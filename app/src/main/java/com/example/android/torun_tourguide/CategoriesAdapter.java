package com.example.android.torun_tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoriesAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 4;
    private Context context;

    public CategoriesAdapter(FragmentManager fm, Context context){
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new TouristsAttractionsFragment();
        }if(position == 1){
            return new AccommodationFragment();
        }else {
            return new TouristsAttractionsFragment();
        }
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return context.getString(R.string.app_name);
        }else{
            return context.getString(R.string.hello_blank_fragment);
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}