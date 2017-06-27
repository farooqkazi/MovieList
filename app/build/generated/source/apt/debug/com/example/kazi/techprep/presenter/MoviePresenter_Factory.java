package com.example.kazi.techprep.presenter;

import com.example.kazi.techprep.api.Interactor;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MoviePresenter_Factory implements Factory<MoviePresenter> {
  private final Provider<Interactor> interactorProvider;

  public MoviePresenter_Factory(Provider<Interactor> interactorProvider) {
    assert interactorProvider != null;
    this.interactorProvider = interactorProvider;
  }

  @Override
  public MoviePresenter get() {
    return new MoviePresenter(interactorProvider.get());
  }

  public static Factory<MoviePresenter> create(Provider<Interactor> interactorProvider) {
    return new MoviePresenter_Factory(interactorProvider);
  }
}
