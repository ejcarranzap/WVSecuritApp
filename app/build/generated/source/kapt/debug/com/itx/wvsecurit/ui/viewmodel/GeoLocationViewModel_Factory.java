// Generated by Dagger (https://dagger.dev).
package com.itx.wvsecurit.ui.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GeoLocationViewModel_Factory implements Factory<GeoLocationViewModel> {
  @Override
  public GeoLocationViewModel get() {
    return newInstance();
  }

  public static GeoLocationViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GeoLocationViewModel newInstance() {
    return new GeoLocationViewModel();
  }

  private static final class InstanceHolder {
    private static final GeoLocationViewModel_Factory INSTANCE = new GeoLocationViewModel_Factory();
  }
}
