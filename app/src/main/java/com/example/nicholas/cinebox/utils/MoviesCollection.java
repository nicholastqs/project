package com.example.nicholas.cinebox.utils;

import android.graphics.Movie;

import com.example.nicholas.cinebox.model.MoviesModel;

public class MoviesCollection {

    private Movie[] movies = new MoviesModel[1];

    public MoviesCollection()
    {
        preapreMovies();
    }

    private void preapreMovies()
    {
        Movie Avengers =  new MoviesModel( "Avengers",
        "https://upload.wikimedia.org/wikipedia/fi/thumb/f/f9/TheAvengers2012Poster.jpg/250px-TheAvengers2012Poster.jpg",
        "27 April, 2018",
        "Action | Adventure | Fantasy",
        "English",
        "PG-13",
        "8.7/10",
        "2h 29min",
        "Iron Man, Thor, the Hulk and the rest of the Avengers unite to battle their most powerful enemy yet -- the evil Thanos. On a mission to collect all six Infinity Stones, Thanos plans to use the artifacts to inflict his twisted will on reality. The fate of the planet and existence itself has never been more uncertain as everything the Avengers have fought for has led up to this moment.");

        movies[0] = Avengers;


    }
}
