package com.example.kazi.techprep.di;

import com.example.kazi.techprep.api.Interactor;
import com.example.kazi.techprep.MainActivity;
import com.example.kazi.techprep.MainActivity_MembersInjector;
import com.example.kazi.techprep.presenter.MoviePresenter;
import com.example.kazi.techprep.presenter.MoviePresenter_Factory;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerMovieComponent implements MovieComponent {
  private Provider<Interactor> getInteractorObjectProvider;

  private Provider<MoviePresenter> moviePresenterProvider;

  private MembersInjector<MainActivity> mainActivityMembersInjector;

  private DaggerMovieComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static MovieComponent create() {
    return builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.getInteractorObjectProvider =
        new Factory<Interactor>() {
          private final MovieModule movieModule = builder.movieModule;

          @Override
          public Interactor get() {
            return Preconditions.checkNotNull(
                movieModule.getInteractorObject(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.moviePresenterProvider = MoviePresenter_Factory.create(getInteractorObjectProvider);

    this.mainActivityMembersInjector = MainActivity_MembersInjector.create(moviePresenterProvider);
  }

  @Override
  public void inject(MainActivity mainActivity) {
    mainActivityMembersInjector.injectMembers(mainActivity);
  }

  public static final class Builder {
    private MovieModule movieModule;

    private Builder() {}

    public MovieComponent build() {
      if (movieModule == null) {
        this.movieModule = new MovieModule();
      }
      return new DaggerMovieComponent(this);
    }

    public Builder movieModule(MovieModule movieModule) {
      this.movieModule = Preconditions.checkNotNull(movieModule);
      return this;
    }
  }
}
