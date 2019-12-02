package com.example.appmusic.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appmusic.R;


public class PlaylistFragment extends Fragment {
    private View view;

    @SuppressLint("ValidFragment")
    public PlaylistFragment(Context context) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.fragment_playlist, null);
    }

    public PlaylistFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return view;
    }
}