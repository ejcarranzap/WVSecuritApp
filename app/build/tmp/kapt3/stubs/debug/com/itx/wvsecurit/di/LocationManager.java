package com.itx.wvsecurit.di;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Looper;
import android.provider.Settings;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.itx.wvsecurit.service.LocationService;
import java.lang.ref.WeakReference;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0007H\u0002JF\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c26\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0010J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000RD\u0010\u000f\u001a8\u00124\u00122\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u00100\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/itx/wvsecurit/di/LocationManager;", "", "()V", "TAG", "", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "fastestInterval", "", "interval", "locationCallBack", "Lcom/google/android/gms/location/LocationCallback;", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "onUpdateLocation", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "latitude", "longitude", "", "priority", "", "removeCallback", "request", "withForegroundService", "", "requestWithService", "requestWithoutService", "stop", "Builder", "app_debug"})
public final class LocationManager {
    @org.jetbrains.annotations.NotNull
    public static final com.itx.wvsecurit.di.LocationManager INSTANCE = null;
    private static final java.lang.String TAG = "LocationManager";
    private static java.lang.ref.WeakReference<android.app.Activity> activity;
    private static com.google.android.gms.location.LocationRequest locationRequest;
    private static java.lang.ref.WeakReference<kotlin.jvm.functions.Function2<java.lang.Double, java.lang.Double, kotlin.Unit>> onUpdateLocation;
    private static long interval = 2000L;
    private static long fastestInterval = 1000L;
    private static int priority = 100;
    private static final com.google.android.gms.location.LocationCallback locationCallBack = null;
    
    private LocationManager() {
        super();
    }
    
    public final void request(boolean withForegroundService, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Double, ? super java.lang.Double, kotlin.Unit> onUpdateLocation) {
    }
    
    private final void requestWithService() {
    }
    
    private final void requestWithoutService() {
    }
    
    public final void stop(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
    
    private final void removeCallback(android.app.Activity activity) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0000J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/itx/wvsecurit/di/LocationManager$Builder;", "", "()V", "build", "create", "Lcom/itx/wvsecurit/di/LocationManager;", "activity", "Landroid/app/Activity;", "setFastestInterval", "fastestInterval", "", "setInterval", "interval", "setPriority", "priority", "", "app_debug"})
    public static final class Builder {
        @org.jetbrains.annotations.NotNull
        public static final com.itx.wvsecurit.di.LocationManager.Builder INSTANCE = null;
        
        private Builder() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.itx.wvsecurit.di.LocationManager.Builder build() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.itx.wvsecurit.di.LocationManager.Builder setInterval(long interval) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.itx.wvsecurit.di.LocationManager.Builder setFastestInterval(long fastestInterval) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.itx.wvsecurit.di.LocationManager.Builder setPriority(int priority) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.itx.wvsecurit.di.LocationManager create(@org.jetbrains.annotations.NotNull
        android.app.Activity activity) {
            return null;
        }
    }
}