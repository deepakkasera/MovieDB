package com.example.deepak.moviedb.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deepak.moviedb.R;
import com.example.deepak.moviedb.model.SingleMovie;

import java.util.ArrayList;

/**
 * Created by deepak on 16/2/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    ArrayList<SingleMovie> movies;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.movieName.setText(movies.get(position).getOriginalTitle());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView movieImage;
        TextView movieName;

        public ViewHolder(View itemView) {
            super(itemView);
            movieImage = (ImageView) itemView.findViewById(R.id.movieImage);
            movieName = (TextView) itemView.findViewById(R.id.movieName);

        }
    }
}
