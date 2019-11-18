package com.example.ap_music.fragments.song;

import com.example.ap_music.base.BaseAdapter;
import com.example.ap_music.model.Song;

public interface SongItemListener extends BaseAdapter.BaseItemListener {
    void onSongClick(Song song);
}
