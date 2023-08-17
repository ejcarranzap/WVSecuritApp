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
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.itx.wvsecurit.ui.view.MainActivity;
import dagger.hilt.android.AndroidEntryPoint;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J@\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\'"}, d2 = {"Lcom/itx/wvsecurit/service/MainService;", "Landroid/app/Service;", "()V", "hasStarted", "", "timer", "Ljava/util/Timer;", "getTimer", "()Ljava/util/Timer;", "setTimer", "(Ljava/util/Timer;)V", "timerTask", "Ljava/util/TimerTask;", "getTimerTask", "()Ljava/util/TimerTask;", "setTimerTask", "(Ljava/util/TimerTask;)V", "onBind", "Landroid/os/IBinder;", "p0", "Landroid/content/Intent;", "onCreate", "", "onStartCommand", "", "intent", "flags", "startId", "startMainService", "channelId", "", "iconResource", "title", "defaults", "contentText", "versionOName", "versionODescription", "stopMainService", "Companion", "app_debug"})
public final class MainService extends android.app.Service {
    @org.jetbrains.annotations.NotNull
    public static final com.itx.wvsecurit.service.MainService.Companion Companion = null;
    private static boolean isMainServiceRunning = false;
    private static final int MAIN_SERVICE_ID = 888;
    private static final java.lang.String ACTION_START_MAIN_SERVICE = "startMainService";
    private static final java.lang.String ACTION_STOP_MAIN_SERVICE = "stopMainService";
    private static long intervalTask = 2000L;
    private static java.lang.ref.WeakReference<kotlin.jvm.functions.Function1<android.app.Service, kotlin.Unit>> delegate;
    private static java.lang.ref.WeakReference<kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit>> delegateCallback;
    private boolean hasStarted = false;
    @org.jetbrains.annotations.Nullable
    private java.util.TimerTask timerTask;
    @org.jetbrains.annotations.Nullable
    private java.util.Timer timer;
    
    public MainService() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable
    android.content.Intent p0) {
        return null;
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.TimerTask getTimerTask() {
        return null;
    }
    
    public final void setTimerTask(@org.jetbrains.annotations.Nullable
    java.util.TimerTask p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Timer getTimer() {
        return null;
    }
    
    public final void setTimer(@org.jetbrains.annotations.Nullable
    java.util.Timer p0) {
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    private final void startMainService(java.lang.String channelId, int iconResource, java.lang.String title, int defaults, java.lang.String contentText, java.lang.String versionOName, java.lang.String versionODescription) {
    }
    
    private final void stopMainService() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u00a2\u0001\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n2!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010$\u001a\u00020\u0013J\u000e\u0010%\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R/\u0010\b\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n0\tX\u0082.\u00a2\u0006\u0002\n\u0000R/\u0010\u0010\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000f0\n0\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006&"}, d2 = {"Lcom/itx/wvsecurit/service/MainService$Companion;", "", "()V", "ACTION_START_MAIN_SERVICE", "", "ACTION_STOP_MAIN_SERVICE", "MAIN_SERVICE_ID", "", "delegate", "Ljava/lang/ref/WeakReference;", "Lkotlin/Function1;", "Landroid/app/Service;", "Lkotlin/ParameterName;", "name", "serviceContext", "", "delegateCallback", "msg", "intervalTask", "", "isMainServiceRunning", "", "()Z", "setMainServiceRunning", "(Z)V", "startMainWithService", "context", "Landroid/content/Context;", "channelId", "iconResource", "title", "defaults", "contentText", "versionOName", "versionODescription", "callBack", "interval", "stopMainWithService", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean isMainServiceRunning() {
            return false;
        }
        
        public final void setMainServiceRunning(boolean p0) {
        }
        
        public final void startMainWithService(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.lang.String channelId, int iconResource, @org.jetbrains.annotations.NotNull
        java.lang.String title, int defaults, @org.jetbrains.annotations.NotNull
        java.lang.String contentText, @org.jetbrains.annotations.NotNull
        java.lang.String versionOName, @org.jetbrains.annotations.NotNull
        java.lang.String versionODescription, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super android.app.Service, kotlin.Unit> delegate, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> callBack, long interval) {
        }
        
        public final void stopMainWithService(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
        }
    }
}