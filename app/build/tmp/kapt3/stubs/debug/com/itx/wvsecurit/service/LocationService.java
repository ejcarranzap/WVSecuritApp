package com.itx.wvsecurit.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.itx.wvsecurit.R;
import com.itx.wvsecurit.domain.usecase.AddGeoLocationUseCase;
import com.itx.wvsecurit.ui.view.MainActivity;
import dagger.hilt.android.AndroidEntryPoint;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J@\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002\u00a8\u0006\u0018"}, d2 = {"Lcom/itx/wvsecurit/service/LocationService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "p0", "Landroid/content/Intent;", "onStartCommand", "", "intent", "flags", "startId", "startLocationService", "", "channelId", "", "iconResource", "title", "defaults", "contentText", "versionOName", "versionODescription", "stopLocationService", "Companion", "app_debug"})
public final class LocationService extends android.app.Service {
    @org.jetbrains.annotations.NotNull
    public static final com.itx.wvsecurit.service.LocationService.Companion Companion = null;
    private static boolean isLocationServiceRunning = false;
    private static final int LOCATION_SERVICE_ID = 777;
    private static final java.lang.String ACTION_START_LOCATION_SERVICE = "startLocationService";
    private static final java.lang.String ACTION_STOP_LOCATION_SERVICE = "stopLocationService";
    private static java.lang.ref.WeakReference<kotlin.jvm.functions.Function1<android.app.Service, kotlin.Unit>> delegate;
    
    public LocationService() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable
    android.content.Intent p0) {
        return null;
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    private final void startLocationService(java.lang.String channelId, int iconResource, java.lang.String title, int defaults, java.lang.String contentText, java.lang.String versionOName, java.lang.String versionODescription) {
    }
    
    private final void stopLocationService() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002Jw\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00042!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nJ\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R/\u0010\b\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n0\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/itx/wvsecurit/service/LocationService$Companion;", "", "()V", "ACTION_START_LOCATION_SERVICE", "", "ACTION_STOP_LOCATION_SERVICE", "LOCATION_SERVICE_ID", "", "delegate", "Ljava/lang/ref/WeakReference;", "Lkotlin/Function1;", "Landroid/app/Service;", "Lkotlin/ParameterName;", "name", "serviceContext", "", "isLocationServiceRunning", "", "()Z", "setLocationServiceRunning", "(Z)V", "startLocationWithService", "context", "Landroid/content/Context;", "channelId", "iconResource", "title", "defaults", "contentText", "versionOName", "versionODescription", "stopLocatingService", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean isLocationServiceRunning() {
            return false;
        }
        
        public final void setLocationServiceRunning(boolean p0) {
        }
        
        public final void startLocationWithService(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.lang.String channelId, int iconResource, @org.jetbrains.annotations.NotNull
        java.lang.String title, int defaults, @org.jetbrains.annotations.NotNull
        java.lang.String contentText, @org.jetbrains.annotations.NotNull
        java.lang.String versionOName, @org.jetbrains.annotations.NotNull
        java.lang.String versionODescription, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super android.app.Service, kotlin.Unit> delegate) {
        }
        
        public final void stopLocatingService(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
        }
    }
}