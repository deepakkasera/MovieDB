package com.example.deepak.moviedb.model;

import java.util.ArrayList;

/**
 * Created by deepak on 16/2/17.
 */

public class MovieList {
    ArrayList<SingleMovie> results;

    public void setMovieList(ArrayList<SingleMovie> movieList) {
        this.results = movieList;
    }

    public ArrayList<SingleMovie> getResults() {
        return results;
    }
}
