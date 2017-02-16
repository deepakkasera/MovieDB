package com.example.deepak.moviedb.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.deepak.moviedb.R;
import com.example.deepak.moviedb.model.MovieList;
import com.example.deepak.moviedb.model.SingleMovie;
import com.example.deepak.moviedb.rest.TheMovieDbApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<SingleMovie> singleMovieArrayList;
    public static final String TAG = "RETROFIT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TheMovieDbApi theMovieDbApi = new TheMovieDbApi();
        theMovieDbApi.getMovieClient().getMovieList().enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                for(SingleMovie singleMovie : response.body().getResults()){
//                    Log.e(TAG, "onResponse: ", + singleMovie.getOriginalTitle());
                      singleMovieArrayList.add(singleMovie);
                }

            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {

            }
        });
    }
}
