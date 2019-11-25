package com.example.ap_music.fragments.album;

import com.example.ap_music.base.BaseAdapter;
import com.example.ap_music.model.Album;

public interface AlbumItemListener extends BaseAdapter.BaseItemListener {
    void albumItemClick(Album album);
}
