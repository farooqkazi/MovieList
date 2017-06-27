package com.example.kazi.techprep.presenter;

import com.example.kazi.techprep.api.Interactor;
import com.example.kazi.techprep.model.Movie;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Kazi on 31/May/17.
 */

/** MVP steps contd*/
/* Step 7 : Create a New class and implement the presenter_interface declared in Contract **/
/* Step 8 : Implement Methods **/
/* Step 9 : Create an object of IView **/
/* Step 10 : Create an object of Interactor goto -> MainActivity **/


public class MoviePresenter implements Contract.IPresenter{

    Contract.IView iView;
    Interactor interactor;

    @Inject // Step 1 : Constructor Injection for Movie Presenter
    public MoviePresenter(Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void bindView(Contract.IView view) {
        this.iView = view;
    }

    @Override
    public void fetchMovies() {
        iView.shouldDismissProgressDialog();
        interactor.getMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Movie>>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(List<Movie> movies) {
                        iView.shouldShowDataInRecyclerView(movies);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView.shouldShowErrorMessage(e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        iView.shouldDismissProgressDialog();

                    }
                });


    }


    @Override
    public void unBindView() {
        iView = null;

    }

    @Override
    public void passErrorMessage() {

    }
}
