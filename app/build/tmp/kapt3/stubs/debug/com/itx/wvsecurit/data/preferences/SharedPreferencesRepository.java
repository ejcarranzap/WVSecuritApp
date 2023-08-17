package com.itx.wvsecurit.data.preferences;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.lifecycle.MutableLiveData;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00108F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00108F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/itx/wvsecurit/data/preferences/SharedPreferencesRepository;", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "editor", "Landroid/content/SharedPreferences$Editor;", "(Landroid/content/SharedPreferences;Landroid/content/SharedPreferences$Editor;)V", "value", "", "gpsTracking", "getGpsTracking", "()Z", "setGpsTracking", "(Z)V", "isLogin", "setLogin", "", "token", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "user", "getUser", "setUser", "clearPreferences", "", "Companion", "app_debug"})
public final class SharedPreferencesRepository {
    private final android.content.SharedPreferences sharedPreferences = null;
    private final android.content.SharedPreferences.Editor editor = null;
    @org.jetbrains.annotations.NotNull
    public static final com.itx.wvsecurit.data.preferences.SharedPreferencesRepository.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String sharedToken = "shared_token";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String sharedUser = "shared_user";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String sharedIsLogin = "shared_is_login";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String sharedIsGpsTraking = "sharedIsGpsTraking";
    
    @javax.inject.Inject
    public SharedPreferencesRepository(@org.jetbrains.annotations.NotNull
    android.content.SharedPreferences sharedPreferences, @org.jetbrains.annotations.NotNull
    android.content.SharedPreferences.Editor editor) {
        super();
    }
    
    public final boolean isLogin() {
        return false;
    }
    
    public final void setLogin(boolean value) {
    }
    
    public final boolean getGpsTracking() {
        return false;
    }
    
    public final void setGpsTracking(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getToken() {
        return null;
    }
    
    public final void setToken(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    public final void clearPreferences() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/itx/wvsecurit/data/preferences/SharedPreferencesRepository$Companion;", "", "()V", "sharedIsGpsTraking", "", "sharedIsLogin", "sharedToken", "sharedUser", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}