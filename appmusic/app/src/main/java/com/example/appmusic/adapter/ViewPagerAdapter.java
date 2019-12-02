package com.example.appmusic.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.appmusic.fragment.AlbumFragment;
import com.example.appmusic.fragment.ArtistFragment;
import com.example.appmusic.fragment.SongFragment;

import java.util.ArrayList;


public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
//    private String[] titles = new String[]{"Bài hát", "Album", "Nghệ sĩ", "Playlist", "Download"};
    private String[] titles = new String[]{"Bài hát", "Album", "Nghệ sĩ"};

    public ViewPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        fragments = new ArrayList<>();
        fragments.add(new SongFragment(context));
        fragments.add(new AlbumFragment(context));
        fragments.add(new ArtistFragment(context));
//        fragments.add(new PlaylistFragment(context));
//        fragments.add(new DownloadFragment(context));
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
