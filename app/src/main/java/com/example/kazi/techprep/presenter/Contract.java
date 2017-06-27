package com.example.kazi.techprep.presenter;

import com.example.kazi.techprep.model.Movie;

import java.util.List;

/**
 * Created by Kazi on 1/Jun/17.
 */

/** MVP steps contd*/
/* Step 4 : Create a contract interface where we define roles for both View and Presenter goto -> MainActivity**/

public interface Contract {

    interface IView{
        void shouldShowProgressDialog();
        void shouldShowDataInRecyclerView(List<Movie> movies);
        void shouldDismissProgressDialog();
        void shouldShowErrorMessage(String error);
    }


    interface IPresenter{
        void bindView(IView view);
        void fetchMovies();
        void unBindView();
        void passErrorMessage();
    }

}
