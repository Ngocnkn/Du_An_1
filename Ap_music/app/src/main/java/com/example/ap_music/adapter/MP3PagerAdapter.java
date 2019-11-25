package com.example.ap_music.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ap_music.base.BaseFragment;

public class MP3PagerAdapter extends FragmentPagerAdapter {
    private BaseFragment[] fms;
    public MP3PagerAdapter(FragmentManager fm, BaseFragment ... fms) {
        super(fm);
        this.fms = fms;
    }

    @Override
    public Fragment getItem(int i) {
        return fms[i];
    }

    @Override
    public int getCount() {
        return fms == null ? 0 : fms.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fms[position].getTitle();
    }
}
