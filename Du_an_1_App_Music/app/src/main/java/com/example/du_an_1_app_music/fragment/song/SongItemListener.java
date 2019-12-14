package com.example.du_an_1_app_music.fragment.song;

import com.example.du_an_1_app_music.base.BaseAdapter;
import com.example.du_an_1_app_music.model.Song;

public interface SongItemListener extends BaseAdapter.BaseItemListener {
    void onSongClick(Song song);
}
