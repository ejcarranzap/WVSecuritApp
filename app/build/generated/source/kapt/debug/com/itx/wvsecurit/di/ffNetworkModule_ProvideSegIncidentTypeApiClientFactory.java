// Generated by Dagger (https://dagger.dev).
package com.itx.wvsecurit.di;

import com.itx.wvsecurit.data.network.SegIncidentTypeApiClient;
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
public final class ffNetworkModule_ProvideSegIncidentTypeApiClientFactory implements Factory<SegIncidentTypeApiClient> {
  private final ffNetworkModule module;

  private final Provider<Retrofit> retrofitProvider;

  public ffNetworkModule_ProvideSegIncidentTypeApiClientFactory(ffNetworkModule module,
      Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public SegIncidentTypeApiClient get() {
    return provideSegIncidentTypeApiClient(module, retrofitProvider.get());
  }

  public static ffNetworkModule_ProvideSegIncidentTypeApiClientFactory create(
      ffNetworkModule module, Provider<Retrofit> retrofitProvider) {
    return new ffNetworkModule_ProvideSegIncidentTypeApiClientFactory(module, retrofitProvider);
  }

  public static SegIncidentTypeApiClient provideSegIncidentTypeApiClient(ffNetworkModule instance,
      Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(instance.provideSegIncidentTypeApiClient(retrofit));
  }
}
