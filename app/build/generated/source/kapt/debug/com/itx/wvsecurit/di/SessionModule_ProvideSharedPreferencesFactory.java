// Generated by Dagger (https://dagger.dev).
package com.itx.wvsecurit.di;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SessionModule_ProvideSharedPreferencesFactory implements Factory<SharedPreferences> {
  private final SessionModule module;

  private final Provider<Context> contextProvider;

  public SessionModule_ProvideSharedPreferencesFactory(SessionModule module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPreferences get() {
    return provideSharedPreferences(module, contextProvider.get());
  }

  public static SessionModule_ProvideSharedPreferencesFactory create(SessionModule module,
      Provider<Context> contextProvider) {
    return new SessionModule_ProvideSharedPreferencesFactory(module, contextProvider);
  }

  public static SharedPreferences provideSharedPreferences(SessionModule instance,
      Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideSharedPreferences(context));
  }
}
