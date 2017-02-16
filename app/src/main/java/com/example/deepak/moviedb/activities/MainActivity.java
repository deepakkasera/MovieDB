package com.example.deepak.moviedb.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.deepak.moviedb.R;
import com.example.deepak.moviedb.adapters.MovieAdapter;
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
    MovieAdapter movieAdapter;
    RecyclerView movieRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        movieAdapter = new MovieAdapter(singleMovieArrayList);
        TheMovieDbApi theMovieDbApi = new TheMovieDbApi();
        theMovieDbApi.getMovieClient().getMovieList().enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                for (SingleMovie singleMovie : response.body().getResults()) {
//                    Log.e(TAG, "onResponse: ", + singleMovie.getOriginalTitle());
                    singleMovieArrayList.add(singleMovie);
                }
                movieAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + "Some Error occured");
            }
        });
        movieRecyclerView = (RecyclerView) findViewById(R.id.movieRecyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        movieRecyclerView.setLayoutManager(layoutManager);
        movieRecyclerView.setAdapter(movieAdapter);
    }
}

