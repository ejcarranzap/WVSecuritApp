package com.itx.wvsecurit.di;

import android.app.Activity;
import com.itx.wvsecurit.service.LocationService;
import com.itx.wvsecurit.service.MainService;
import java.lang.ref.WeakReference;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J)\u0010\u000f\u001a\u00020\u000e2!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tJ\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R1\u0010\b\u001a%\u0012!\u0012\u001f\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\t0\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/itx/wvsecurit/di/MainServiceManager;", "", "()V", "activity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "interval", "", "onUpdateTask", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "msg", "", "request", "requestWithService", "stop", "Builder", "app_debug"})
public final class MainServiceManager {
    @org.jetbrains.annotations.NotNull()
    public static final com.itx.wvsecurit.di.MainServiceManager INSTANCE = null;
    private static java.lang.ref.WeakReference<kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit>> onUpdateTask;
    private static java.lang.ref.WeakReference<android.app.Activity> activity;
    private static long interval = 2000L;
    
    private MainServiceManager() {
        super();
    }
    
    private final void requestWithService() {
    }
    
    public final void request(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onUpdateTask) {
    }
    
    public final void stop(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2 = {"Lcom/itx/wvsecurit/di/MainServiceManager$Builder;", "", "()V", "create", "Lcom/itx/wvsecurit/di/MainServiceManager;", "activity", "Landroid/app/Activity;", "setInterval", "interval", "", "app_debug"})
    public static final class Builder {
        @org.jetbrains.annotations.NotNull()
        public static final com.itx.wvsecurit.di.MainServiceManager.Builder INSTANCE = null;
        
        private Builder() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.itx.wvsecurit.di.MainServiceManager.Builder setInterval(long interval) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.itx.wvsecurit.di.MainServiceManager create(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity) {
            return null;
        }
    }
}