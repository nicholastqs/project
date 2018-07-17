package com.example.nicholas.cinebox.utils;

import android.graphics.Movie;

import com.example.nicholas.cinebox.model.MoviesModel;

public class MoviesCollection {

    private MoviesModel[] movies = new MoviesModel[1];

    public MoviesCollection()
    {
        prepareMovies();
    }

    private void prepareMovies()
    {
        MoviesModel Avengers =  new MoviesModel(
                "https://upload.wikimedia.org/wikipedia/fi/thumb/f/f9/TheAvengers2012Poster.jpg/250px-TheAvengers2012Poster.jpg",
                "Avengers",
                "Action | Adventure | Fantasy",
                "PG-13",
                "Iron Man, Thor, the Hulk and the rest of the Avengers unite to battle their most powerful enemy yet -- the evil Thanos. On a mission to collect all six Infinity Stones, Thanos plans to use the artifacts to inflict his twisted will on reality. The fate of the planet and existence itself has never been more uncertain as everything the Avengers have fought for has led up to this moment.",
                "27 April 2018",
                "2h 29min");

        movies[0] = Avengers;


    }
}
