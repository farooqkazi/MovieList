package com.example.kazi.techprep.di;

import com.example.kazi.techprep.MainActivity;

import dagger.Component;

/**
 * Created by Kazi on 1/Jun/17.
 */

/** Dagger Steps Contd **/
// Step 4 : Create a new Component Interface.
// Step 5 : Annotate Component.
// Step 6 : Add a dependency to the Movie Component by adding Movie Module class.
// Step 7 : Mention where it needs to be Injected, goto ->

@Component(dependencies = MovieModule.class)
public interface MovieComponent {

    void inject (MainActivity mainActivity);

}
