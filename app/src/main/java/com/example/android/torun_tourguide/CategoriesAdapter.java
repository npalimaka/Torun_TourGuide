package com.example.android.torun_tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoriesAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 4;
    private Context context;

    public CategoriesAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MonumentsFragment();
        } else if (position == 1) {
            return new HotelsFragment();
        } else if (position == 2) {
            return new BarsFragment();
        } else {
            return new EventsFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.monuments);
        } else if (position == 1) {
            return context.getString(R.string.hotels);
        }else if (position == 2) {
            return context.getString(R.string.bars);
        } else {
            return context.getString(R.string.events);
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}