package com.example.appmusic.listener;


import com.example.appmusic.model.Song;

import java.util.List;

/**
 * Created by Android on 11/8/2016.
 */

public interface OnListListener {
    void onItemClick(int pos);

    void onItemClick(List<Song> songs);
}
