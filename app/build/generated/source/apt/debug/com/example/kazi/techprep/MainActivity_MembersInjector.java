package com.example.kazi.techprep;

import com.example.kazi.techprep.presenter.MoviePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<MoviePresenter> moviePresenterProvider;

  public MainActivity_MembersInjector(Provider<MoviePresenter> moviePresenterProvider) {
    assert moviePresenterProvider != null;
    this.moviePresenterProvider = moviePresenterProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<MoviePresenter> moviePresenterProvider) {
    return new MainActivity_MembersInjector(moviePresenterProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.moviePresenter = moviePresenterProvider.get();
  }

  public static void injectMoviePresenter(
      MainActivity instance, Provider<MoviePresenter> moviePresenterProvider) {
    instance.moviePresenter = moviePresenterProvider.get();
  }
}
