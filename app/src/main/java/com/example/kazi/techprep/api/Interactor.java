package com.example.kazi.techprep.api;

import com.example.kazi.techprep.model.Movie;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Kazi on 1/Jun/17.
 */
/** MVP begins*/
/* Step 1 : Create an Interactor Interface with same Observable but without Get, goto -> ApiManager **/
public interface Interactor {

  Observable<List<Movie>> getMovies();
}
