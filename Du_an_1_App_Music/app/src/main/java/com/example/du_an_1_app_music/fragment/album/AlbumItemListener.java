package com.example.du_an_1_app_music.fragment.album;

import com.example.du_an_1_app_music.base.BaseAdapter;
import com.example.du_an_1_app_music.model.Album;

public interface AlbumItemListener extends BaseAdapter.BaseItemListener {
    void onAlbumItemClick(Album album);
}
