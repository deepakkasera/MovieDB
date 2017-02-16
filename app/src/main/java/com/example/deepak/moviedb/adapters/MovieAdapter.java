package com.example.deepak.moviedb.adapters;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deepak.moviedb.R;
import com.example.deepak.moviedb.model.SingleMovie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by deepak on 16/2/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    public MovieAdapter(ArrayList<SingleMovie> movies) {
        this.movies = movies;
    }

    ArrayList<SingleMovie> movies;
    Context context;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewHolder = new ViewHolder(li.inflate(R.layout.single_movie,null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.movieName.setText(movies.get(position).getOriginalTitle());
        String poster = "http://image.tmdb.org/t/p/w500" + movies.get(position).getPosterPath();
        Picasso.with(context)
                .load(poster)
                .fit()
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .into(holder.movieImage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder  extends  RecyclerView.ViewHolder{
        TextView movieName;
        ImageView movieImage;

        public ViewHolder(View itemView) {
            super(itemView);
            movieName = (TextView) itemView.findViewById(R.id.movieName);
            movieImage = (ImageView) itemView.findViewById(R.id.movieImage);
        }
    }
}
