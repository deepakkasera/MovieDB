package com.example.deepak.moviedb.rest;

import com.example.deepak.moviedb.model.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;
/**
 * Created by deepak on 16/2/17.
 */

public interface MovieClient {

    @GET("movie/popular?api_key=97f469b9e89b30f1f7d07e8b35973e56&page=1&language=en-US")
    Call<MovieList> getMovieList();

}
