package com.example.du_an_1_app_music.fragment.album;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.du_an_1_app_music.R;
import com.example.du_an_1_app_music.activity.MainActivity;
import com.example.du_an_1_app_music.base.BaseAdapter;
import com.example.du_an_1_app_music.base.BaseFragment;
import com.example.du_an_1_app_music.databinding.FragmentAlbumDetailBinding;
import com.example.du_an_1_app_music.model.Song;
import com.example.du_an_1_app_music.utils.SystemDataUtils;

import java.util.ArrayList;

public class AlbumDetailFragment extends BaseFragment<FragmentAlbumDetailBinding> {
    private SystemDataUtils dataUtils;
    private BaseAdapter<Song> adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        MainActivity main = (MainActivity) getActivity();
//        main.getSupportActionBar().hide();
        initView();
    }

    private void initView() {
        binding.recyclerAlbumDetail.setAdapter(adapter);
    }

    public void setData(String albumID, Context context) {
        dataUtils = new SystemDataUtils(context);
        ArrayList<Song> arr = dataUtils.getSongByAlbum(albumID);
        adapter = new BaseAdapter<>(context,R.layout.item_song);
        adapter.setData(arr);
    }

    @Override
    public void onPause() {
        super.onPause();
        MainActivity main = (MainActivity) getActivity();
        main.getSupportActionBar().show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_album_detail;
    }

    @Override
    public String getTitle() {
        return "Album Detail";
    }
}
