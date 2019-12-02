package com.example.appmusic.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.example.appmusic.R;
import com.example.appmusic.adapter.SongBaseAdapter;
import com.example.appmusic.finalapp.MainFragmentActivity;
import com.example.appmusic.finalapp.PlaySongActivity;
import com.example.appmusic.listener.OnPlayMusic;
import com.example.appmusic.model.Song;
import com.example.appmusic.utils.CommonValue;

import java.util.ArrayList;
import java.util.List;


public class SongFragment extends Fragment {
    //implements View.OnClickListener {
    private View view;
    private SongBaseAdapter adapter;
    private ArrayList<Song> arrSong;
    private ListView lvSong;
    private Context context;
    private MainFragmentActivity mainFragmentActivity;
    private ImageView ivSearch;
    private TextView tvName;
    private SearchView editSearch;

    @SuppressLint("ValidFragment")
    public SongFragment(Context context) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        this.context = context;
        view = layoutInflater.inflate(R.layout.fragment_song, null);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainFragmentActivity = (MainFragmentActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainFragmentActivity = null;
    }

    public SongFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        lvSong = (ListView) view.findViewById(R.id.lv_song);
        ivSearch = (ImageView) mainFragmentActivity.findViewById(R.id.im_other_viewpager);
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvName.setVisibility(View.INVISIBLE);
                editSearch.setVisibility(View.VISIBLE);
                editSearch.setFocusable(true);
                editSearch.setFocusableInTouchMode(true);
                editSearch.requestFocus();
                editSearch.requestFocusFromTouch();
                editSearch.setActivated(true);
                editSearch.setIconifiedByDefault(true);
            }
        });
        tvName = (TextView) mainFragmentActivity.findViewById(R.id.tv_name_viewpager);
        editSearch = (SearchView) mainFragmentActivity.findViewById(R.id.edt_search);
//        sharedPreferences = mainFragmentActivity.getSharedPreferences(CommonValue.KEY_SAVE_MODE, Context.MODE_PRIVATE);
//        loopMusic = sharedPreferences.getInt(CommonValue.KEY_LOOP_MUSIC, 1);
//        shuffle = sharedPreferences.getBoolean(CommonValue.KEY_SHUFFLE, true);
//        int id = editSearch.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
//        TextView textView = (TextView) editSearch.findViewById(id);
//        textView.setTextColor(Color.WHITE);
        editSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                InputMethodManager in = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                in.hideSoftInputFromWindow(editSearch.getWindowToken(), 0);
                tvName.setVisibility(View.VISIBLE);
                editSearch.setVisibility(View.INVISIBLE);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrSong = (ArrayList<Song>) MainFragmentActivity.songs;
                adapter = new SongBaseAdapter(getContext(), arrSong, new OnPlayMusic() {
                    @Override
                    public void playSong(List<Song> paths, int position) {
                        arrSong = (ArrayList<Song>) paths;
                        mainFragmentActivity.playSong(paths, position);
                        Intent intent = new Intent(getActivity(), PlaySongActivity.class);
                        intent.putExtra(CommonValue.KEY_SEND_A_SONG, MainFragmentActivity.songs.get(position));
                        String sizeOfSong = position + "/" + MainFragmentActivity.songs.size();
                        intent.putExtra(CommonValue.KEY_SEND_SIZE_OF_SONG, sizeOfSong);
                        startActivity(intent);
                    }
                });
                lvSong.setAdapter(adapter);

                adapter.getFilter().filter(newText.toLowerCase().trim());
                adapter.notifyDataSetChanged();
                return true;
            }
        });
        if (MainFragmentActivity.songs != null) {
            adapter = new SongBaseAdapter(context, (ArrayList<Song>) MainFragmentActivity.songs, new OnPlayMusic() {
                @Override
                public void playSong(List<Song> paths, int position) {
                    arrSong = (ArrayList<Song>) paths;
                    mainFragmentActivity.playSong(paths, position);
                    Intent intent = new Intent(getActivity(), PlaySongActivity.class);
                    intent.putExtra(CommonValue.KEY_SEND_A_SONG, MainFragmentActivity.songs.get(position));
                    String sizeOfSong = position + "/" + MainFragmentActivity.songs.size();
                    intent.putExtra(CommonValue.KEY_SEND_SIZE_OF_SONG, sizeOfSong);
                    startActivity(intent);
                }
            });
            lvSong.setAdapter(adapter);
        }

        return view;
    }


}
