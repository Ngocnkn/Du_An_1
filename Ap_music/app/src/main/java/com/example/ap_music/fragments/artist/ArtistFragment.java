package com.example.ap_music.fragments.artist;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.ap_music.R;
import com.example.ap_music.base.BaseAdapter;
import com.example.ap_music.base.BaseFragment;
import com.example.ap_music.databinding.FragmentArtistBinding;
import com.example.ap_music.model.Artist;
import com.example.ap_music.utils.SystemDataUtils;

public class ArtistFragment extends BaseFragment<FragmentArtistBinding> implements ArtistItemListener{

    private BaseAdapter<Artist> adapter;
    private SystemDataUtils dataUtils;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_artist;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new BaseAdapter<>(getContext(), R.layout.item_artist);
        dataUtils = new SystemDataUtils(getContext());
        adapter.setData(dataUtils.getArtists());
        adapter.setListener(this);
        binding.lvArtist.setAdapter(adapter);
    }

    @Override
    public String getTitle() {
        return "Artist";
    }

    @Override
    public void onArtistClick(Artist artist) {

    }

    @Override
    public void executeSearch(String key) {
        adapter.getFilter().filter(key);
    }
}
