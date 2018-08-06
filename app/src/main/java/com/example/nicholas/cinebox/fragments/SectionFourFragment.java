package com.example.nicholas.cinebox.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.nicholas.cinebox.R;
import com.example.nicholas.cinebox.adapter.MoviesAdapter;
import com.example.nicholas.cinebox.model.MoviesModel;
import com.example.nicholas.cinebox.utils.MovieData;
import java.util.ArrayList;

public class SectionFourFragment extends Fragment {

  ArrayList<MoviesModel> movies = new ArrayList<>();
  @BindView(R.id.latest_list)
  RecyclerView mLatestList;
  @BindView(R.id.trending_list)
  RecyclerView mTrendingList;
  @BindView(R.id.genre_list)
  RecyclerView mGenreList;
  private MoviesAdapter mAdapter;
  LinearLayoutManager mManager;
  View mView;

  public SectionFourFragment() {
    // Required empty public constructor
  }


  public static SectionFourFragment newInstance() {
    SectionFourFragment fragment = new SectionFourFragment();
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
    mView = inflater.inflate(R.layout.fragment_section_four, container, false);

    ButterKnife.bind(this, mView);

    mAdapter = new MoviesAdapter(movies, getActivity());
    mManager = new LinearLayoutManager(getActivity());

    latestList();
    trendingList();
    genreList();

    movies.clear();
    MovieData movieData = new MovieData(movies);
    movieData.prepareMovies();

    return mView;
  }

  private void latestList() {
    SnapHelper mSnapHelper = new PagerSnapHelper();
    mLatestList.setLayoutManager(
        new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
    mLatestList.setAdapter(mAdapter);
    mLatestList.setItemAnimator(new DefaultItemAnimator());
    mSnapHelper.attachToRecyclerView(mLatestList);
  }

  private void trendingList() {
    SnapHelper mSnapHelper = new PagerSnapHelper();
    mTrendingList.setLayoutManager(
        new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
    mTrendingList.setAdapter(mAdapter);
    mTrendingList.setItemAnimator(new DefaultItemAnimator());
    mSnapHelper.attachToRecyclerView(mTrendingList);
  }

  private void genreList() {
    SnapHelper mSnapHelper = new PagerSnapHelper();
    mGenreList.setLayoutManager(
        new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
    mGenreList.setAdapter(mAdapter);
    mGenreList.setItemAnimator(new DefaultItemAnimator());
    mSnapHelper.attachToRecyclerView(mGenreList);
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
