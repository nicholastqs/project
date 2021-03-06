package com.example.nicholas.cinebox.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nicholas.cinebox.R;
import com.example.nicholas.cinebox.adapter.MoviesAdapter;
import com.example.nicholas.cinebox.model.MoviesModel;

import com.example.nicholas.cinebox.utils.MovieData;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SectionTwoFragment extends Fragment {

    ArrayList<MoviesModel> movies = new ArrayList<>();
    @BindView(R.id.movies_list)
    RecyclerView mRecyclerList;
    private MoviesAdapter mAdapter;
    LinearLayoutManager mManager;

    View mView;
    Context mContext;

    public SectionTwoFragment() {
        // Required empty public constructor
    }

    public static SectionTwoFragment newInstance() {
        SectionTwoFragment fragment = new SectionTwoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_section_two, container, false);

        ButterKnife.bind(this, mView);

        mAdapter = new MoviesAdapter(movies, getActivity());
        mManager = new LinearLayoutManager(getActivity());
        mRecyclerList.setLayoutManager(mManager);
        mRecyclerList.setAdapter(mAdapter);
        mRecyclerList.setItemAnimator(new DefaultItemAnimator());

        movies.clear();
        MovieData movieData = new MovieData(movies);
        movieData.prepareMovies();

        return mView;
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
