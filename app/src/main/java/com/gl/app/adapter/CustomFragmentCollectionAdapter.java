package com.gl.app.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class CustomFragmentCollectionAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;

    public CustomFragmentCollectionAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        position = position + 1;

        if (position == 1) {
            return "Basic";
        } else {
            return "Scientific ";
        }

    }
}
