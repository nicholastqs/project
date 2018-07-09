package com.example.nicholas.cinebox.model;

public class MoviesModel {

    private String image;
    private String title;
    private String genre;
    private String pg;
    private String description;
    private String release_date;
    private String duration;

    public MoviesModel() {
    }

    public MoviesModel(String image, String title, String genre, String pg, String description, String release_date, String duration) {
        this.image = image;
        this.title = title;
        this.genre = genre;
        this.pg = pg;
        this.description = description;
        this.release_date = release_date;
        this.duration = duration;
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


}
