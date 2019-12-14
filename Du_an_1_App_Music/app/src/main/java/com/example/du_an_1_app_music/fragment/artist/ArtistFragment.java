package com.example.du_an_1_app_music.fragment.artist;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.du_an_1_app_music.R;
import com.example.du_an_1_app_music.base.BaseAdapter;
import com.example.du_an_1_app_music.base.BaseFragment;
import com.example.du_an_1_app_music.databinding.FragmentArtistBinding;
import com.example.du_an_1_app_music.fragment.album.AlbumItemListener;
import com.example.du_an_1_app_music.model.Album;
import com.example.du_an_1_app_music.model.Artist;
import com.example.du_an_1_app_music.utils.SystemDataUtils;

public class ArtistFragment extends BaseFragment<FragmentArtistBinding> implements ArtistItemListener {
    private BaseAdapter<Artist> adapter;
    private SystemDataUtils dataUtils;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_artist;
    }

    @Override
    public String getTitle() {
        return "Artist";
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new BaseAdapter<>(getContext(), R.layout.item_artist);
        dataUtils = new SystemDataUtils(getContext());
        adapter.setData(dataUtils.getArtists());
        adapter.setListener(this);
        binding.recyclerArtist.setAdapter(adapter);
    }

    @Override
    public void onArtistClick(Artist artist) {

    }
}
