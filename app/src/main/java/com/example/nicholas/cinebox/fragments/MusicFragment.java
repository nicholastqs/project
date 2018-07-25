package com.example.nicholas.cinebox.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nicholas.cinebox.PlaySong;
import com.example.nicholas.cinebox.R;
import com.example.nicholas.cinebox.model.MusicModel;
import com.example.nicholas.cinebox.utils.SongCollection;


public class MusicFragment extends Fragment {

    public MusicFragment() {
        // Required empty public constructor
    }


    public static MusicFragment newInstance() {
        MusicFragment fragment = new MusicFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private SongCollection songCollection = new SongCollection();

    public static String getResourceId(Context context, View view)
    {
        String id = context.getResources().getResourceEntryName(view.getId());

        return id;
    }

    public void handleSelection (View view)
    {
        String resourceId = getResourceId(getActivity(), view );
        MusicModel selectedSong = songCollection.searchById(resourceId);
        sendDataToActivity(selectedSong);
    }

    public void sendDataToActivity(MusicModel song) {
        Intent intent = new Intent(getActivity(), PlaySong.class);


        intent.putExtra("id", song.getId());
        intent.putExtra("title", song.getTitle());
        intent.putExtra("artist", song.getArtist());
        intent.putExtra("fileLink", song.getFileLink());
        intent.putExtra("coverArt", song.getCoverArt());

        startActivity(intent);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}

