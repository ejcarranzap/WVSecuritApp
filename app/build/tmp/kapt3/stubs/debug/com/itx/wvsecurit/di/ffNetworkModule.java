package com.itx.wvsecurit.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itx.wvsecurit.data.constants.Constants;
import com.itx.wvsecurit.data.network.*;
import com.itx.wvsecurit.data.preferences.SharedPreferencesRepository;
import com.itx.wvsecurit.tool.HttpHeader;
import com.itx.wvsecurit.tool.MyInterceptor;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0014H\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u00a8\u0006&"}, d2 = {"Lcom/itx/wvsecurit/di/ffNetworkModule;", "", "()V", "getHttpClient", "Lokhttp3/OkHttpClient;", "myInterceptor", "Lcom/itx/wvsecurit/tool/MyInterceptor;", "getUnsafeOkHttpClient", "Lokhttp3/OkHttpClient$Builder;", "provideFileDownloadApiClient", "Lcom/itx/wvsecurit/data/network/FileDownloadApiClient;", "retrofit", "Lretrofit2/Retrofit;", "provideGeoAlertTypeApiClient", "Lcom/itx/wvsecurit/data/network/GeoAlertTypeApiClient;", "provideGeoLocationAlertApiClient", "Lcom/itx/wvsecurit/data/network/GeoLocationAlertApiClient;", "provideGeoLocationApiClient", "Lcom/itx/wvsecurit/data/network/GeoLocationApiClient;", "provideGson", "Lcom/google/gson/Gson;", "provideLoginApiClient", "Lcom/itx/wvsecurit/data/network/LoginApiClient;", "provideMyInterceptor", "sharedPreferencesRepository", "Lcom/itx/wvsecurit/data/preferences/SharedPreferencesRepository;", "provideRetrofit", "gson", "provideSegIncidentApiClient", "Lcom/itx/wvsecurit/data/network/SegIncidentApiClient;", "provideSegIncidentTypeApiClient", "Lcom/itx/wvsecurit/data/network/SegIncidentTypeApiClient;", "provideSegNewsApiClient", "Lcom/itx/wvsecurit/data/network/SegNewsApiClient;", "provideSendMail", "Lcom/itx/wvsecurit/data/network/SendMailService;", "provideUploadService", "Lcom/itx/wvsecurit/data/network/UploadService;", "app_debug"})
@dagger.Module
public final class ffNetworkModule {
    
    public ffNetworkModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.google.gson.Gson provideGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull
    com.itx.wvsecurit.tool.MyInterceptor myInterceptor, @org.jetbrains.annotations.NotNull
    com.google.gson.Gson gson) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.itx.wvsecurit.data.network.LoginApiClient provideLoginApiClient(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.itx.wvsecurit.data.network.GeoLocationApiClient provideGeoLocationApiClient(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.itx.wvsecurit.data.network.GeoLocationAlertApiClient provideGeoLocationAlertApiClient(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.itx.wvsecurit.data.network.SegIncidentTypeApiClient provideSegIncidentTypeApiClient(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.itx.wvsecurit.data.network.SegIncidentApiClient provideSegIncidentApiClient(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.itx.wvsecurit.data.network.SegNewsApiClient provideSegNewsApiClient(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.itx.wvsecurit.data.network.GeoAlertTypeApiClient provideGeoAlertTypeApiClient(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.itx.wvsecurit.data.network.FileDownloadApiClient provideFileDownloadApiClient(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.itx.wvsecurit.data.network.UploadService provideUploadService(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.itx.wvsecurit.data.network.SendMailService provideSendMail(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.itx.wvsecurit.tool.MyInterceptor provideMyInterceptor(@org.jetbrains.annotations.NotNull
    com.itx.wvsecurit.data.preferences.SharedPreferencesRepository sharedPreferencesRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final okhttp3.OkHttpClient getHttpClient(@org.jetbrains.annotations.NotNull
    com.itx.wvsecurit.tool.MyInterceptor myInterceptor) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @javax.inject.Singleton
    @dagger.Provides
    public final okhttp3.OkHttpClient.Builder getUnsafeOkHttpClient() {
        return null;
    }
}