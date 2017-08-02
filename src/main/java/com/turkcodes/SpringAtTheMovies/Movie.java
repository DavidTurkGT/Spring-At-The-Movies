package com.turkcodes.SpringAtTheMovies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by David Turk on 8/2/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    private String title;
    private String poster_path;
    private String overview;
    private double popularity;

    public Movie() {
    }

    public Movie(String title, String poster_path, String overview, double popularity) {
        this.title = title;
        this.poster_path = poster_path;
        this.overview = overview;
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = "http://image.tmdb.org/t/p/w185/" + poster_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                '}';
    }
}
