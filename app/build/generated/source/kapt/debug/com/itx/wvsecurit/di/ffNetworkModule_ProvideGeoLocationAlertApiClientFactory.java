// Generated by Dagger (https://dagger.dev).
package com.itx.wvsecurit.di;

import com.itx.wvsecurit.data.network.GeoLocationAlertApiClient;
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
public final class ffNetworkModule_ProvideGeoLocationAlertApiClientFactory implements Factory<GeoLocationAlertApiClient> {
  private final ffNetworkModule module;

  private final Provider<Retrofit> retrofitProvider;

  public ffNetworkModule_ProvideGeoLocationAlertApiClientFactory(ffNetworkModule module,
      Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public GeoLocationAlertApiClient get() {
    return provideGeoLocationAlertApiClient(module, retrofitProvider.get());
  }

  public static ffNetworkModule_ProvideGeoLocationAlertApiClientFactory create(
      ffNetworkModule module, Provider<Retrofit> retrofitProvider) {
    return new ffNetworkModule_ProvideGeoLocationAlertApiClientFactory(module, retrofitProvider);
  }

  public static GeoLocationAlertApiClient provideGeoLocationAlertApiClient(ffNetworkModule instance,
      Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(instance.provideGeoLocationAlertApiClient(retrofit));
  }
}
