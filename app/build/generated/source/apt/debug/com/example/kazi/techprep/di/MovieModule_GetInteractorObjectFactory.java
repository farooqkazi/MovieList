package com.example.kazi.techprep.di;

import com.example.kazi.techprep.api.Interactor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MovieModule_GetInteractorObjectFactory implements Factory<Interactor> {
  private final MovieModule module;

  public MovieModule_GetInteractorObjectFactory(MovieModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Interactor get() {
    return Preconditions.checkNotNull(
        module.getInteractorObject(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Interactor> create(MovieModule module) {
    return new MovieModule_GetInteractorObjectFactory(module);
  }
}
