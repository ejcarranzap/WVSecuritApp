// Generated by Dagger (https://dagger.dev).
package com.itx.wvsecurit.domain.usecase;

import com.itx.wvsecurit.data.network.SegIncidentTypeApiClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GetSegIncidentTypeUseCase_Factory implements Factory<GetSegIncidentTypeUseCase> {
  private final Provider<SegIncidentTypeApiClient> segIncidentTypeApiClientProvider;

  public GetSegIncidentTypeUseCase_Factory(
      Provider<SegIncidentTypeApiClient> segIncidentTypeApiClientProvider) {
    this.segIncidentTypeApiClientProvider = segIncidentTypeApiClientProvider;
  }

  @Override
  public GetSegIncidentTypeUseCase get() {
    return newInstance(segIncidentTypeApiClientProvider.get());
  }

  public static GetSegIncidentTypeUseCase_Factory create(
      Provider<SegIncidentTypeApiClient> segIncidentTypeApiClientProvider) {
    return new GetSegIncidentTypeUseCase_Factory(segIncidentTypeApiClientProvider);
  }

  public static GetSegIncidentTypeUseCase newInstance(
      SegIncidentTypeApiClient segIncidentTypeApiClient) {
    return new GetSegIncidentTypeUseCase(segIncidentTypeApiClient);
  }
}