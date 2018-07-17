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

    private MoviesCollection moviesCollection = new MoviesCollection();

    private List<MoviesModel> movies = new ArrayList<>();
    @BindView(R.id.movies_list)
    RecyclerView mRecyclerList;
    private MoviesAdapter mAdapter;
    LinearLayoutManager mManager;

    View mView;
    Context mContext;

    public SectionOneFragment() {
        // Required empty public constructor
    }

    public static SectionOneFragment newInstance() {
        SectionOneFragment fragment = new SectionOneFragment();
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
        mView = inflater.inflate(R.layout.fragment_section_one, container, false);

        ButterKnife.bind(this, mView);

        mAdapter = new MoviesAdapter(movies, getActivity());
        mManager = new LinearLayoutManager(getActivity());
        mRecyclerList.setLayoutManager(mManager);
        mRecyclerList.setAdapter(mAdapter);
        mRecyclerList.setItemAnimator(new DefaultItemAnimator());

        movies.clear();
        moviesData();

        return mView;
    }

    private void moviesData() {
        MoviesModel avengers = new MoviesModel();
        movies.add(avengers);

        MoviesModel jurassic = new MoviesModel(MoviesData.JURASSIC_IMAGE, MoviesData.JURASSIC_TITLE, MoviesData.JURASSIC_GENRE, MoviesData.JURASSIC_PG, MoviesData.JURASSIC_DETAILS, MoviesData.JURASSIC_DATE, MoviesData.JURASSIC_DURATION);
        movies.add(jurassic);

        MoviesModel kingsman = new MoviesModel(MoviesData.KINGSMAN_IMAGE, MoviesData.KINGSMAN_TITLE, MoviesData.KINGSMAN_GENRE, MoviesData.KINGSMAN_PG, MoviesData.KINGSMAN_DETAILS, MoviesData.KINGSMAN_DATE, MoviesData.KINGSMAN_DURATION);
        movies.add(kingsman);

        mAdapter.notifyDataSetChanged();
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
