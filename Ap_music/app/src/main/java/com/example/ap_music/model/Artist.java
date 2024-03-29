package com.example.ap_music.model;

import android.provider.MediaStore;

public class Artist extends BaseModel{
    @FieldInfo(fieldName = MediaStore.Audio.Artists.ARTIST)
    private String name;
    @FieldInfo(fieldName = MediaStore.Audio.Artists.NUMBER_OF_ALBUMS)
    private int numberOfAlbum;
    @FieldInfo(fieldName = MediaStore.Audio.Artists.NUMBER_OF_TRACKS)
    private int numberOfTrack;

    public String getName() {
        return name;
    }

    public int getNumberOfAlbum() {
        return numberOfAlbum;
    }

    public int getNumberOfTrack() {
        return numberOfTrack;
    }

    @Override
    public boolean checkFilter(String key) {
        return name.toLowerCase().contains(key.toLowerCase());
    }
}
