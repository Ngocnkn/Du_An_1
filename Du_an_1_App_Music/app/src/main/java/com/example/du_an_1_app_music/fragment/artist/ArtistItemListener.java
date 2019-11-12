package com.example.du_an_1_app_music.fragment.artist;

import com.example.du_an_1_app_music.base.BaseAdapter;
import com.example.du_an_1_app_music.model.Artist;

public interface ArtistItemListener extends BaseAdapter.BaseItemListener {
    void onArtistClick(Artist artist);
}
