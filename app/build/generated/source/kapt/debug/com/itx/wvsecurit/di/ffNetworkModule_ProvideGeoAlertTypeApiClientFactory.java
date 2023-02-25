// Generated by Dagger (https://dagger.dev).
package com.itx.wvsecurit.di;

import com.itx.wvsecurit.data.network.GeoAlertTypeApiClient;
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
public final class ffNetworkModule_ProvideGeoAlertTypeApiClientFactory implements Factory<GeoAlertTypeApiClient> {
  private final ffNetworkModule module;

  private final Provider<Retrofit> retrofitProvider;

  public ffNetworkModule_ProvideGeoAlertTypeApiClientFactory(ffNetworkModule module,
      Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public GeoAlertTypeApiClient get() {
    return provideGeoAlertTypeApiClient(module, retrofitProvider.get());
  }

  public static ffNetworkModule_ProvideGeoAlertTypeApiClientFactory create(ffNetworkModule module,
      Provider<Retrofit> retrofitProvider) {
    return new ffNetworkModule_ProvideGeoAlertTypeApiClientFactory(module, retrofitProvider);
  }

  public static GeoAlertTypeApiClient provideGeoAlertTypeApiClient(ffNetworkModule instance,
      Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(instance.provideGeoAlertTypeApiClient(retrofit));
  }
}