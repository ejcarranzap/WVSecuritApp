// Generated by Dagger (https://dagger.dev).
package com.itx.wvsecurit.di;

import com.itx.wvsecurit.data.database.WvSecuritDatabase;
import com.itx.wvsecurit.data.database.dao.SegIncidentTypeDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RoomModule_ProvideSegIncidentTypeDaoFactory implements Factory<SegIncidentTypeDao> {
  private final Provider<WvSecuritDatabase> dbProvider;

  public RoomModule_ProvideSegIncidentTypeDaoFactory(Provider<WvSecuritDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public SegIncidentTypeDao get() {
    return provideSegIncidentTypeDao(dbProvider.get());
  }

  public static RoomModule_ProvideSegIncidentTypeDaoFactory create(
      Provider<WvSecuritDatabase> dbProvider) {
    return new RoomModule_ProvideSegIncidentTypeDaoFactory(dbProvider);
  }

  public static SegIncidentTypeDao provideSegIncidentTypeDao(WvSecuritDatabase db) {
    return Preconditions.checkNotNullFromProvides(RoomModule.INSTANCE.provideSegIncidentTypeDao(db));
  }
}