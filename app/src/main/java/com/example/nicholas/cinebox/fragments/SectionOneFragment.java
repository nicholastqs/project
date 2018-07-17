package com.example.nicholas.cinebox.fragments;

import android.content.Context;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nicholas.cinebox.adapter.MoviesAdapter;
import com.example.nicholas.cinebox.R;
import com.example.nicholas.cinebox.model.MoviesModel;
import com.example.nicholas.cinebox.utils.MoviesCollection;
import com.example.nicholas.cinebox.utils.MoviesData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SectionOneFragment extends Fragment {

    MoviesCollection moviesCollection = new MoviesCollection();

    ArrayList<MoviesModel> movies = new ArrayList<>();
    @BindView(R.id.movies_list)
    RecyclerView mRecyclerList;
    private MoviesAdapter mAdapter;
    LinearLayoutManager mManager;

    View mView;
    Context mContext;

    public SectionOneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_section_one, container, false);

        ButterKnife.bind(this, mView);

        mAdapter = new MoviesAdapter(movies, getActivity());
        mManager = new LinearLayoutManager(getActivity());
        mRecyclerList.setLayoutManager(mManager);
        mRecyclerList.setAdapter(mAdapter);
        mRecyclerList.setItemAnimator(new DefaultItemAnimator());

        movies.clear();
        prepareMovies();



        return mView;
    }


    public void prepareMovies() {
        MoviesModel model;
        model = new MoviesModel("https://upload.wikimedia.org/wikipedia/fi/thumb/f/f9/TheAvengers2012Poster.jpg/250px-TheAvengers2012Poster.jpg", "Avengers", "Action | Adventure | Fantasy", "PG-13", "Iron Man, Thor, the Hulk and the rest of the Avengers unite to battle their most powerful enemy yet -- the evil Thanos. On a mission to collect all six Infinity Stones, Thanos plans to use the artifacts to inflict his twisted will on reality. The fate of the planet and existence itself has never been more uncertain as everything the Avengers have fought for has led up to this moment.", "27 April 2018", "2h 29min");
        movies.add(model);

        model = new MoviesModel("https://upload.wikimedia.org/wikipedia/fi/thumb/f/f9/TheAvengers2012Poster.jpg/250px-TheAvengers2012Poster.jpg",
                "Avengers", "Action | Adventure | Fantasy", "PG-13", "Iron Man, Thor, the Hulk and the rest of the Avengers unite to battle their most powerful enemy yet -- the evil Thanos. On a mission to collect all six Infinity Stones, Thanos plans to use the artifacts to inflict his twisted will on reality. The fate of the planet and existence itself has never been more uncertain as everything the Avengers have fought for has led up to this moment.", "27 April 2018", "2h 29min");
        movies.add(model);
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
