package com.example.kazi.techprep;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.kazi.techprep.adapter.MovieAdapter;
import com.example.kazi.techprep.di.MyApp;
import com.example.kazi.techprep.presenter.Contract;
import com.example.kazi.techprep.helper.ItemsMarginDecorator;
import com.example.kazi.techprep.helper.NetworkCheck;
import com.example.kazi.techprep.model.Movie;
import com.example.kazi.techprep.presenter.MoviePresenter;

import java.util.List;

import javax.inject.Inject;


/** MVP steps contd*/
/* Step 5 : Let the MainActivity or Fragment implement the IView **/
/* Step 6 : Implement Methods goto -> Presenter **/
/* Step 11 : Initialize the Presenter in onCreate **/
/* Step 12 : Initialize the Interactor **/
/* Step 13 : Bind the Presenter in establishConnection() **/
/* Step 15 : Unbind the Presenter in onDestroy() **/

public class MainActivity extends AppCompatActivity implements Contract.IView {

    //ApiService apiService;
    SwipeRefreshLayout swiperLayout;
    private RecyclerView recyclerView_movies;
    AlertDialog alertDialog;
    private ProgressDialog progressDialog;
    //private Interactor interactor;
    @Inject       // Injects MovieComponent.
    MoviePresenter moviePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Step 14 : Injection Activity
        ((MyApp)getApplication()).getMovieComponent().inject(this);

        progressDialog = new ProgressDialog(this);

        establishConnection();
        initializeRecyclerView();
        callService();

        swiperLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);
        swiperLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                callService();

            }
        });

    }

    private void establishConnection() {
        //interactor = new ApiManager();
        //moviePresenter = new MoviePresenter(interactor);
        //apiService = ApiManager.getConnection();
        moviePresenter.bindView(this);
    }

    public void initializeRecyclerView(){

        recyclerView_movies = (RecyclerView)findViewById(R.id.movies_recycler_view);
        recyclerView_movies.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_movies.addItemDecoration(new ItemsMarginDecorator(getApplication().getResources().getDimensionPixelSize(R.dimen.item_margin)));
    }

   /* public void callService(){
        if(NetworkCheck.isNetworkAvailable(this)){
            apiService.getMovies()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<List<Movie>>() {
                        @Override
                        public void onCompleted() {
                            Log.i("Values ","OnComplete Called ");
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(List<Movie> movies) {

                            recyclerView_movies.setAdapter(new MovieAdapter(movies, R.layout.list_item_movie, getApplicationContext()));

                        }
                    });

        }

        else
        {
            alertDialog = new AlertDialog.Builder(this)
                    .setMessage("No Network")
                    .setTitle("Please Connect to the Internet")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            alertDialog.dismiss();
                            finish();
                        }
                    })
                    .show();
        }

    } */

    public void callService(){
        if (NetworkCheck.isNetworkAvailable(this)) {
            moviePresenter.fetchMovies();

        }
        else{

        }

    }

    @Override
    public void shouldShowProgressDialog() {

        progressDialog.setMessage("Loading Data");
        progressDialog.setTitle("Movies");
        progressDialog.show();

    }

    @Override
    public void shouldShowDataInRecyclerView(List<Movie> movies) {

        recyclerView_movies.setAdapter(new MovieAdapter(movies, R.layout.list_item_movie, getApplicationContext()));

    }

    @Override
    public void shouldDismissProgressDialog() {
        if(progressDialog.isShowing() || progressDialog!=null){
            progressDialog.dismiss();
        }

    }

    @Override
    public void shouldShowErrorMessage(String error) {
        //Toast.makeText((getApplicationContext()), "No Network Available", Toast.LENGTH_LONG).show();
        alertDialog = new AlertDialog.Builder(this)
                .setMessage("No Network")
                .setTitle("Please Connect to the Internet")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                        finish();
                    }
                })
                .show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        moviePresenter.unBindView();
    }
}

