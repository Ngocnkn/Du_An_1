package com.example.ap_music.fragments.song;

import android.os.Bundle;


import androidx.annotation.Nullable;

import com.example.ap_music.R;
import com.example.ap_music.activities.MainActivity;
import com.example.ap_music.base.BaseAdapter;
import com.example.ap_music.base.BaseFragment;
import com.example.ap_music.databinding.FragmentSongBinding;
import com.example.ap_music.model.Song;
import com.example.ap_music.utils.SystemDataUtils;

public class SongFragment extends BaseFragment<FragmentSongBinding> implements SongItemListener {

    private BaseAdapter<Song> adapter;
    private SystemDataUtils dataUtils;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_song;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dataUtils = new SystemDataUtils(getContext());
        adapter = new BaseAdapter<>(getContext(), R.layout.item_song);
        adapter.setData(dataUtils.getSongs());
        adapter.setListener(this);
        binding.lvSong.setAdapter(adapter);
    }

    @Override
    public String getTitle() {
        return "Song";
    }

    @Override
    public void onSongClick(Song song) {
        int index = adapter.getData().indexOf(song);
        MainActivity act = (MainActivity) getActivity();
        act.getService().setData(adapter.getData());
        act.getService().create(index);
    }

    @Override
    public void executeSearch(String key) {
        adapter.getFilter().filter(key);
    }
}
