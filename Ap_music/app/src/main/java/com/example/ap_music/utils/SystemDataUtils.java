package com.example.ap_music.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.example.ap_music.model.Album;
import com.example.ap_music.model.Artist;
import com.example.ap_music.model.BaseModel;
import com.example.ap_music.model.FieldInfo;
import com.example.ap_music.model.Song;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class SystemDataUtils {
    private ContentResolver resolver;

    public SystemDataUtils(Context context) {
        resolver = context.getContentResolver();
    }

    public ArrayList<Song> getSongs() {
        Cursor cursor = resolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null, null, null, null);
        return getData(cursor, Song.class);
    }

    public ArrayList<Artist> getArtists() {
        Cursor cursor = resolver.query(
                MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI,
                null, null, null, null);
        return getData(cursor, Artist.class);
    }

    public ArrayList<Album> getAlbums() {
        Cursor cursor = resolver.query(
                MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
                null, null, null, null
        );
        return getData(cursor, Album.class);
    }

    private <T extends BaseModel> ArrayList<T> getData(
            Cursor cursor, Class<T> clz) {
        ArrayList<T> data = new ArrayList<>();

        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            try {
                T item = getRow(cursor, clz);
                data.add(item);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cursor.moveToNext();
        }
        return data;
    }

    private <T extends BaseModel> T getRow(Cursor cursor, Class<T> clz) throws Exception {
        Field[] fields = clz.getDeclaredFields();
        T t = clz.newInstance();
        for (Field f : fields) {
            f.setAccessible(true);
            FieldInfo info = f.getAnnotation(FieldInfo.class);
            if (info == null){
                continue;
            }
            int index = cursor.getColumnIndex(info.fieldName());
            String value = cursor.getString(index);
            mapValue(t, value, f);
        }
        return t;
    }

    private <T extends BaseModel> void mapValue(T t, String value,
                                                Field f) throws IllegalAccessException {
        String type = f.getType().getSimpleName();
        if (type.equalsIgnoreCase("int")){
            f.setInt(t, Integer.parseInt(value));
            return;
        }
        if (type.equalsIgnoreCase(Long.class.getSimpleName())){
            f.setLong(t, Long.parseLong(value));
            return;
        }
        if (type.equalsIgnoreCase(Boolean.class.getSimpleName())){
            f.setBoolean(t, Boolean.parseBoolean(value));
            return;
        }
        if (type.equalsIgnoreCase(Float.class.getSimpleName())){
            f.setFloat(t, Float.parseFloat(value));
            return;
        }
        if (type.equalsIgnoreCase(Double.class.getSimpleName())){
            f.setDouble(t, Double.parseDouble(value));
            return;
        }
        f.set(t, value);
    }
}
