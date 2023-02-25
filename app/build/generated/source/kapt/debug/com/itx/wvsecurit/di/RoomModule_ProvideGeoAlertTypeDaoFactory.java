// Generated by Dagger (https://dagger.dev).
package com.itx.wvsecurit.di;

import com.itx.wvsecurit.data.database.WvSecuritDatabase;
import com.itx.wvsecurit.data.database.dao.GeoAlertTypeDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RoomModule_ProvideGeoAlertTypeDaoFactory implements Factory<GeoAlertTypeDao> {
  private final Provider<WvSecuritDatabase> dbProvider;

  public RoomModule_ProvideGeoAlertTypeDaoFactory(Provider<WvSecuritDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public GeoAlertTypeDao get() {
    return provideGeoAlertTypeDao(dbProvider.get());
  }

  public static RoomModule_ProvideGeoAlertTypeDaoFactory create(
      Provider<WvSecuritDatabase> dbProvider) {
    return new RoomModule_ProvideGeoAlertTypeDaoFactory(dbProvider);
  }

  public static GeoAlertTypeDao provideGeoAlertTypeDao(WvSecuritDatabase db) {
    return Preconditions.checkNotNullFromProvides(RoomModule.INSTANCE.provideGeoAlertTypeDao(db));
  }
}
