package com.example.kazi.techprep.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kazi.techprep.R;
import com.example.kazi.techprep.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Kazi on 31/May/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Holder>{

    List<Movie> movies;
    int list_item_movie;
    Context applicationContext;

    public MovieAdapter(List<Movie> movies, int list_item_movie, Context applicationContext) {
        this.applicationContext = applicationContext;
        this.list_item_movie = list_item_movie;
        this.movies = movies;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie,parent,false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        holder.movieName.setText(movies.get(position).getTitle());
        holder.movieRating.setText(String.format("Rating: " + movies.get(position).getRating().toString()));
        holder.movieGenre.setText(String.format("Genre: " + movies.get(position).getGenre().toString()));
        holder.movieYear.setText(String.format("Date Released: " + movies.get(position).getReleaseYear().toString()));
        String url = movies.get(position).getImage();
        Picasso.with(applicationContext).load(url)
                .into(holder.movieImage);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        TextView movieName;
        TextView movieRating;
        TextView movieGenre;
        TextView movieYear;
        ImageView movieImage;


        public Holder(View itemView) {
            super(itemView);

            movieName = (TextView) itemView.findViewById(R.id.textViewMovieName);
            movieRating = (TextView) itemView.findViewById(R.id.textViewRating);
            movieGenre = (TextView) itemView.findViewById(R.id.textViewMovieGenre);
            movieYear = (TextView) itemView.findViewById(R.id.textViewMovieInfo);
            movieImage = (ImageView) itemView.findViewById(R.id.imageViewMovie);
        }
    }
}
