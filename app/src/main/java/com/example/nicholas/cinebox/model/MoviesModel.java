package com.example.nicholas.cinebox.model;

public class MoviesModel {

    private String image;
    private String title;
    private String genre;
    private String pg;
    private String description;
    private String release_date;
    private String duration;
    private String background;
    private String trailer;
    private String language;
    private String rating;

    public MoviesModel() {
    }

  public MoviesModel(String image, String title, String genre, String pg,
      String description, String release_date, String duration, String background,
      String trailer, String language, String rating) {
    this.image = image;
    this.title = title;
    this.genre = genre;
    this.pg = pg;
    this.description = description;
    this.release_date = release_date;
    this.duration = duration;
    this.background = background;
    this.trailer = trailer;
    this.language = language;
    this.rating = rating;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getPg() {
    return pg;
  }

  public void setPg(String pg) {
    this.pg = pg;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRelease_date() {
    return release_date;
  }

  public void setRelease_date(String release_date) {
    this.release_date = release_date;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getBackground() {
    return background;
  }

  public void setBackground(String background) {
    this.background = background;
  }

  public String getTrailer() {
    return trailer;
  }

  public void setTrailer(String trailer) {
    this.trailer = trailer;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }
}

// Avengers Trailer: https://www.youtube.com/watch?v=6ZfuNTqbHE8
//Jurassic World Trailer : https://www.youtube.com/watch?v=RFinNxS5KN4
//Kingsman Trailer: https://www.youtube.com/watch?v=4PggfbzJcvA
//Deadpool2 Trailer: https://www.youtube.com/watch?v=I4tFNfROlqk&vl=en