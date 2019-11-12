package com.example.du_an_1_app_music.fragment.album;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.du_an_1_app_music.R;
import com.example.du_an_1_app_music.activity.MainActivity;
import com.example.du_an_1_app_music.base.BaseAdapter;
import com.example.du_an_1_app_music.base.BaseFragment;
import com.example.du_an_1_app_music.databinding.FragmentAlbumsBinding;
import com.example.du_an_1_app_music.model.Album;
import com.example.du_an_1_app_music.utils.SystemDataUtils;

import java.util.ArrayList;

public class AlbumFragment extends BaseFragment<FragmentAlbumsBinding> implements AlbumItemListener {
    private BaseAdapter<Album> adapter;
    private SystemDataUtils dataUtils;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_albums;
    }

    @Override
    public String getTitle() {
        return "Albums";
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new BaseAdapter<>(getContext(), R.layout.item_album);
        dataUtils = new SystemDataUtils(getContext());
        adapter.setData(dataUtils.getAlbum());
        adapter.setListener(this);
        binding.recyclerAlbums.setAdapter(adapter);
    }

    @Override
    public void onAlbumItemClick(Album album) {
        String albumID = album.getAlbumID();
        MainActivity main = (MainActivity) getActivity();
        main.addFragmentAlbumDetail(albumID);
    }
}
