package com.example.kazi.techprep.di;

import com.example.kazi.techprep.api.Interactor;
import com.example.kazi.techprep.api.ApiManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kazi on 1/Jun/17.
 */

/** Dagger begins */
// Dagger is informed how to construct an Interactor to provide for the Presenter.

// Step 1.1 : Create a new class Module
// Step 2 : Annotate a Module.
// Step 3 : Get Interactor Object by creating a new method, goto -> Component.
@Module
public class MovieModule {


    @Provides
    public Interactor getInteractorObject(){

        return new ApiManager();
    }

}
