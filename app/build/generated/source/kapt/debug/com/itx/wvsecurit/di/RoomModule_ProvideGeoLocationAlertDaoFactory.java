// Generated by Dagger (https://dagger.dev).
package com.itx.wvsecurit.di;

import com.itx.wvsecurit.data.database.WvSecuritDatabase;
import com.itx.wvsecurit.data.database.dao.GeoLocationAlertDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RoomModule_ProvideGeoLocationAlertDaoFactory implements Factory<GeoLocationAlertDao> {
  private final Provider<WvSecuritDatabase> dbProvider;

  public RoomModule_ProvideGeoLocationAlertDaoFactory(Provider<WvSecuritDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public GeoLocationAlertDao get() {
    return provideGeoLocationAlertDao(dbProvider.get());
  }

  public static RoomModule_ProvideGeoLocationAlertDaoFactory create(
      Provider<WvSecuritDatabase> dbProvider) {
    return new RoomModule_ProvideGeoLocationAlertDaoFactory(dbProvider);
  }

  public static GeoLocationAlertDao provideGeoLocationAlertDao(WvSecuritDatabase db) {
    return Preconditions.checkNotNullFromProvides(RoomModule.INSTANCE.provideGeoLocationAlertDao(db));
  }
}
