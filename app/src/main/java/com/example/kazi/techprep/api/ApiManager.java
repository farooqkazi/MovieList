package com.example.kazi.techprep.api;

import com.example.kazi.techprep.helper.Constants;
import com.example.kazi.techprep.model.Movie;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Kazi on 5/May/17.
 */

/** MVP steps contd*/
/* Step 2 : Let the ApiManager implement the Interactor Interface **/
/* Step 3 :  Create an empty Constructor to call getConnection() method, goto -> Contract**/
public class ApiManager implements Interactor {


    public static ApiService getConnection(){

        Retrofit retrofit = null;
        OkHttpClient okHttpClient = null;


        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();


        if (retrofit==null){
            retrofit= new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        return retrofit.create(ApiService.class);
    }

    public ApiManager() {
        getConnection();
    }

    @Override
    public Observable<List<Movie>> getMovies() {
        return getConnection().getMovies();
    }
}
