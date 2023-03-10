// Generated by Dagger (https://dagger.dev).
package com.itx.wvsecurit.data.database;

import com.itx.wvsecurit.data.database.dao.SegNewsDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SegNewsRepository_Factory implements Factory<SegNewsRepository> {
  private final Provider<SegNewsDao> daoProvider;

  public SegNewsRepository_Factory(Provider<SegNewsDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public SegNewsRepository get() {
    return newInstance(daoProvider.get());
  }

  public static SegNewsRepository_Factory create(Provider<SegNewsDao> daoProvider) {
    return new SegNewsRepository_Factory(daoProvider);
  }

  public static SegNewsRepository newInstance(SegNewsDao dao) {
    return new SegNewsRepository(dao);
  }
}
