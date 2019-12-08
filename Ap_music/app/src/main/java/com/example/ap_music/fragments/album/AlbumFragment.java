package com.example.ap_music.fragments.album;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.ap_music.R;
import com.example.ap_music.base.BaseAdapter;
import com.example.ap_music.base.BaseFragment;
import com.example.ap_music.databinding.FragmentAlbumBinding;
import com.example.ap_music.model.Album;
import com.example.ap_music.utils.SystemDataUtils;

public class AlbumFragment extends BaseFragment<FragmentAlbumBinding> implements AlbumItemListener{

    private BaseAdapter<Album> adapter;
    private SystemDataUtils dataUtils;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_album;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dataUtils = new SystemDataUtils(getContext());
        adapter = new BaseAdapter<>(getContext(), R.layout.item_album);
        adapter.setData(dataUtils.getAlbums());
        adapter.setListener(this);
        binding.lvAlbum.setAdapter(adapter);
    }

    @Override
    public String getTitle() {
        return "Album";
    }

    @Override
    public void albumItemClick(Album album) {

    }

    @Override
    public void executeSearch(String key) {
        adapter.getFilter().filter(key);
    }
}