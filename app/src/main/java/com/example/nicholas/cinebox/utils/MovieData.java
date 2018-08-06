package com.example.nicholas.cinebox.utils;

import com.example.nicholas.cinebox.model.MoviesModel;
import java.util.ArrayList;

/*
 * Created by Mbuodile Obiosio on 8/6/18
 * cazewonder@gmail.com
 * https://twtter.com/cazewonder
 */
public class MovieData {

  public MovieData(ArrayList<MoviesModel> movies) {
    this.movies = movies;
  }

  ArrayList<MoviesModel> movies;

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
}
