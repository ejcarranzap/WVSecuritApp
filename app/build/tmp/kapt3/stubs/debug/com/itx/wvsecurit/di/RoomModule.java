package com.itx.wvsecurit.di;

import android.content.Context;
import androidx.room.Room;
import com.itx.wvsecurit.data.database.WvSecuritDatabase;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\r\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/itx/wvsecurit/di/RoomModule;", "", "()V", "DATABASE_NAME", "", "provideGeoAlertTypeDao", "Lcom/itx/wvsecurit/data/database/dao/GeoAlertTypeDao;", "db", "Lcom/itx/wvsecurit/data/database/WvSecuritDatabase;", "provideGeoLocationAlertDao", "Lcom/itx/wvsecurit/data/database/dao/GeoLocationAlertDao;", "provideGeoLocationDao", "Lcom/itx/wvsecurit/data/database/dao/GeoLocationDao;", "provideRoom", "context", "Landroid/content/Context;", "provideSegIncidentDao", "Lcom/itx/wvsecurit/data/database/dao/SegIncidentDao;", "provideSegIncidentTypeDao", "Lcom/itx/wvsecurit/data/database/dao/SegIncidentTypeDao;", "provideSegNewsDao", "Lcom/itx/wvsecurit/data/database/dao/SegNewsDao;", "app_debug"})
@dagger.Module()
public final class RoomModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.itx.wvsecurit.di.RoomModule INSTANCE = null;
    private static final java.lang.String DATABASE_NAME = "wvsecurit_database";
    
    private RoomModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.itx.wvsecurit.data.database.WvSecuritDatabase provideRoom(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.itx.wvsecurit.data.database.dao.GeoLocationDao provideGeoLocationDao(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.WvSecuritDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.itx.wvsecurit.data.database.dao.SegIncidentTypeDao provideSegIncidentTypeDao(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.WvSecuritDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.itx.wvsecurit.data.database.dao.GeoAlertTypeDao provideGeoAlertTypeDao(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.WvSecuritDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.itx.wvsecurit.data.database.dao.GeoLocationAlertDao provideGeoLocationAlertDao(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.WvSecuritDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.itx.wvsecurit.data.database.dao.SegIncidentDao provideSegIncidentDao(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.WvSecuritDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.itx.wvsecurit.data.database.dao.SegNewsDao provideSegNewsDao(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.database.WvSecuritDatabase db) {
        return null;
    }
}