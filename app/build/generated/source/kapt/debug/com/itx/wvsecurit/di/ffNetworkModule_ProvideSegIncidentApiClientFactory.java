// Generated by Dagger (https://dagger.dev).
package com.itx.wvsecurit.di;

import com.itx.wvsecurit.data.network.SegIncidentApiClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ffNetworkModule_ProvideSegIncidentApiClientFactory implements Factory<SegIncidentApiClient> {
  private final ffNetworkModule module;

  private final Provider<Retrofit> retrofitProvider;

  public ffNetworkModule_ProvideSegIncidentApiClientFactory(ffNetworkModule module,
      Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public SegIncidentApiClient get() {
    return provideSegIncidentApiClient(module, retrofitProvider.get());
  }

  public static ffNetworkModule_ProvideSegIncidentApiClientFactory create(ffNetworkModule module,
      Provider<Retrofit> retrofitProvider) {
    return new ffNetworkModule_ProvideSegIncidentApiClientFactory(module, retrofitProvider);
  }

  public static SegIncidentApiClient provideSegIncidentApiClient(ffNetworkModule instance,
      Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(instance.provideSegIncidentApiClient(retrofit));
  }
}
