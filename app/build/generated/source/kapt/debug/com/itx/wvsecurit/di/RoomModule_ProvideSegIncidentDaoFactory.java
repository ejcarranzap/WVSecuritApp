// Generated by Dagger (https://dagger.dev).
package com.itx.wvsecurit.di;

import com.itx.wvsecurit.data.database.WvSecuritDatabase;
import com.itx.wvsecurit.data.database.dao.SegIncidentDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RoomModule_ProvideSegIncidentDaoFactory implements Factory<SegIncidentDao> {
  private final Provider<WvSecuritDatabase> dbProvider;

  public RoomModule_ProvideSegIncidentDaoFactory(Provider<WvSecuritDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public SegIncidentDao get() {
    return provideSegIncidentDao(dbProvider.get());
  }

  public static RoomModule_ProvideSegIncidentDaoFactory create(
      Provider<WvSecuritDatabase> dbProvider) {
    return new RoomModule_ProvideSegIncidentDaoFactory(dbProvider);
  }

  public static SegIncidentDao provideSegIncidentDao(WvSecuritDatabase db) {
    return Preconditions.checkNotNullFromProvides(RoomModule.INSTANCE.provideSegIncidentDao(db));
  }
}
