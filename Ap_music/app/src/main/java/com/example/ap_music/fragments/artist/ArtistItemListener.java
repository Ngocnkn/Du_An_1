package com.example.ap_music.fragments.artist;

import com.example.ap_music.base.BaseAdapter;
import com.example.ap_music.model.Artist;

public interface ArtistItemListener extends BaseAdapter.BaseItemListener {
    void onArtistClick(Artist artist);
}
