package com.example.deepak.moviedb.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by deepak on 16/2/17.
 */

public class TheMovieDbApi {

    public MovieClient getMovieClient(){
        String BASE_URL = "https://api.themoviedb.org/3/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MovieClient.class);
    }

}
