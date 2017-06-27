package com.example.kazi.techprep.api;



import com.example.kazi.techprep.helper.Constants;
import com.example.kazi.techprep.model.Movie;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;



/**
 * Created by Kazi on 5/May/17.
 */


public interface ApiService {

    @GET(Constants.MOVIE_API)
    Call<List<Movie>> getMovie();

    @GET(Constants.MOVIE_API)
    Observable<List<Movie>> getMovies();

}
