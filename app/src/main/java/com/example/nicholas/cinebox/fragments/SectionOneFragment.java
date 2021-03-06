package com.example.nicholas.cinebox.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

public class SectionOneFragment extends Fragment {

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

  public SectionOneFragment() {
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
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    mView = inflater.inflate(R.layout.fragment_section_one, container, false);

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

  public void prepareMovies() {
    MoviesModel model;

    model = new MoviesModel(
        "https://upload.wikimedia.org/wikipedia/fi/thumb/f/f9/TheAvengers2012Poster.jpg/250px-TheAvengers2012Poster.jpg",
        "Avengers",
        "Action | Adventure | Fantasy",
        "PG-13",
        "Iron Man, Thor, the Hulk and the rest of the Avengers unite to battle their most powerful enemy yet -- the evil Thanos. On a mission to collect all six Infinity Stones, Thanos plans to use the artifacts to inflict his twisted will on reality. The fate of the planet and existence itself has never been more uncertain as everything the Avengers have fought for has led up to this moment.",
        "27 April 2018",
        "2h 29min",
        "https://upload.wikimedia.org/wikipedia/fi/thumb/f/f9/TheAvengers2012Poster.jpg/250px-TheAvengers2012Poster.jpg",
        "https://www.youtube.com/watch?v=6ZfuNTqbHE8",
        "English",
        "4.5");
    movies.add(model);

    model = new MoviesModel(
        "https://www.dvdsreleasedates.com/posters/800/J/Jurassic-World-Fallen-Kingdom-2018-movie-poster.jpg",
        "Jurassic World: Fallen Kingdom",
        "Action | Adventure | Sci-Fi",
        "PG-13",
        "A volcanic eruption threatens the remaining dinosaurs on the island of Isla Nublar,where the creatures have freely roamed for several years after the demise of an animal theme park known as Jurassic World.",
        "27 April, 2018",
        "2h 29min",
        "https://www.dvdsreleasedates.com/posters/800/J/Jurassic-World-Fallen-Kingdom-2018-movie-poster.jpg",
        "https://www.youtube.com/watch?v=RFinNxS5KN4",
        "English",
        "4.8");
    movies.add(model);

    model = new MoviesModel(
        "https://m.media-amazon.com/images/M/MV5BMjQ3OTgzMzY4NF5BMl5BanBnXkFtZTgwOTc4OTQyMzI@._V1_UX182_CR0,0,182,268_AL_.jpg",
        "Kingsman: The Golden Circle",
        "Action | Adventure | Comedy",
        "M18",
        "With their headquarters destroyed and the world held hostage, members of Kingsman find new allies when they discover a spy organization in the United States known as Statesman. In an adventure that tests their strength and wits, the elite secret agents from both sides of the pond band together to battle a ruthless enemy and save the day, something that's becoming a bit of a habit for Eggsy.",
        "22 Sept 2017",
        " 2h 21min",
        "https://m.media-amazon.com/images/M/MV5BMjQ3OTgzMzY4NF5BMl5BanBnXkFtZTgwOTc4OTQyMzI@._V1_UX182_CR0,0,182,268_AL_.jpg",
        "https://www.youtube.com/watch?v=4PggfbzJcvA",
        "English",
        "4.5");
    movies.add(model);

    model = new MoviesModel(
        "http://cdn.collider.com/wp-content/uploads/2018/05/deadpool-2-poster-final.jpg",
        "Deadpool2",
        "Action | Adventure | Comedy",
        "M18",
        "Wisecracking mercenary Deadpool meets Russell, an angry teenage mutant who lives at an orphanage. When Russell becomes the target of Cable -- a genetically enhanced soldier from the future -- Deadpool realizes that he'll need some help saving the boy from such a superior enemy. He soon joins forces with Bedlam, Shatterstar, Domino and other powerful mutants to protect young Russell from Cable and his advanced weaponry.",
        "Release: 18 May 2018",
        "Duration: 1h 59min",
        "http://cdn.collider.com/wp-content/uploads/2018/05/deadpool-2-poster-final.jpg",
        "https://www.youtube.com/watch?v=I4tFNfROlqk&vl=en",
        "English",
        "4.2");
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
