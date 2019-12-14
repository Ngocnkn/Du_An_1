package com.example.appmusic.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appmusic.R;
import com.example.appmusic.adapter.AlbumBaseAdapter;
import com.example.appmusic.finalapp.MainFragmentActivity;
import com.example.appmusic.finalapp.ShowListSongActivity;
import com.example.appmusic.listener.OnListListener;
import com.example.appmusic.model.Song;
import com.example.appmusic.utils.CommonValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 11/7/2016.
 */

public class AlbumFragment extends Fragment {
    private View view;
    private ListView lvAlbum;
    private Context context;
    private AlbumBaseAdapter albumBaseAdapter;
//    private ImageView ivSearch;
//    private TextView tvName;
//    private SearchView editSearch;

    @SuppressLint("ValidFragment")
    public AlbumFragment(Context context) {
        this.context = context;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.fragment_album, null);
    }

    public AlbumFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        lvAlbum = (ListView) view.findViewById(R.id.lv_album);
        if (MainFragmentActivity.albums != null) {
            albumBaseAdapter = new AlbumBaseAdapter(context, MainFragmentActivity.albums, new OnListListener() {
                @Override
                public void onItemClick(int pos) {

                }

                @Override
                public void onItemClick(List<Song> songs) {
                    Intent intent = new Intent(getActivity(), ShowListSongActivity.class);
                    intent.putParcelableArrayListExtra(CommonValue.KEY_LIST_SONG_CLICK, (ArrayList<? extends Parcelable>) songs);
                    intent.putExtra(CommonValue.KEY_FROM_SHOW_LIST, 0);
                    startActivity(intent);
                }
            });
            lvAlbum.setAdapter(albumBaseAdapter);
        }
        return view;
    }

}