package com.example.kazi.techprep.di;

import android.app.Application;

/**
 * Created by Kazi on 1/Jun/17.
 */

/** Dagger Steps Contd **/
// Step 8 : Create a new class and extend Application class.
// Step 9 : Add MyApp in Manifest file.
// Step 10 : Create Component Object.
// Step 11 : Generate a Getter for Component Object.
// Step 12 : onCreate method needs DaggerComponent.
// Step 13 : Rebuild once, so its automatically generated, goto-> MainActivity

public class MyApp extends Application {

    MovieComponent movieComponent;

    public MovieComponent getMovieComponent() {
        return movieComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        movieComponent = DaggerMovieComponent.create();


    }
}
