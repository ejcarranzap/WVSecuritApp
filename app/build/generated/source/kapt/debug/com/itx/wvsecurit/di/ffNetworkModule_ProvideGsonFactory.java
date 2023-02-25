// Generated by Dagger (https://dagger.dev).
package com.itx.wvsecurit.di;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ffNetworkModule_ProvideGsonFactory implements Factory<Gson> {
  private final ffNetworkModule module;

  public ffNetworkModule_ProvideGsonFactory(ffNetworkModule module) {
    this.module = module;
  }

  @Override
  public Gson get() {
    return provideGson(module);
  }

  public static ffNetworkModule_ProvideGsonFactory create(ffNetworkModule module) {
    return new ffNetworkModule_ProvideGsonFactory(module);
  }

  public static Gson provideGson(ffNetworkModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideGson());
  }
}
