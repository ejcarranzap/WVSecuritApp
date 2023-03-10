// Generated by Dagger (https://dagger.dev).
package com.itx.wvsecurit.di;

import com.google.gson.Gson;
import com.itx.wvsecurit.tool.MyInterceptor;
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
public final class ffNetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final ffNetworkModule module;

  private final Provider<MyInterceptor> myInterceptorProvider;

  private final Provider<Gson> gsonProvider;

  public ffNetworkModule_ProvideRetrofitFactory(ffNetworkModule module,
      Provider<MyInterceptor> myInterceptorProvider, Provider<Gson> gsonProvider) {
    this.module = module;
    this.myInterceptorProvider = myInterceptorProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(module, myInterceptorProvider.get(), gsonProvider.get());
  }

  public static ffNetworkModule_ProvideRetrofitFactory create(ffNetworkModule module,
      Provider<MyInterceptor> myInterceptorProvider, Provider<Gson> gsonProvider) {
    return new ffNetworkModule_ProvideRetrofitFactory(module, myInterceptorProvider, gsonProvider);
  }

  public static Retrofit provideRetrofit(ffNetworkModule instance, MyInterceptor myInterceptor,
      Gson gson) {
    return Preconditions.checkNotNullFromProvides(instance.provideRetrofit(myInterceptor, gson));
  }
}
