package com.turkcodes.SpringAtTheMovies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;

/**
 * Created by David Turk on 8/2/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsPage {
    List<Movie> results = new ArrayList<>();

    public ResultsPage() {
    }

    public ResultsPage(List<Movie> results) {
        this.results = results;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
