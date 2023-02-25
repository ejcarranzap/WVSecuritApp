package com.itx.wvsecurit.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.itx.wvsecurit.data.preferences.SharedPreferencesRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000eR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/itx/wvsecurit/ui/viewmodel/SharedPreferencesViewModel;", "Landroidx/lifecycle/ViewModel;", "sharedPreferencesRepository", "Lcom/itx/wvsecurit/data/preferences/SharedPreferencesRepository;", "(Lcom/itx/wvsecurit/data/preferences/SharedPreferencesRepository;)V", "isGpsTracking", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "setGpsTracking", "(Landroidx/lifecycle/MutableLiveData;)V", "isLogin", "setLogin", "token", "", "getToken", "setToken", "user", "getUser", "setUser", "onCreate", "", "setIsGpsTracking", "value", "setIsLogin", "app_debug"})
public final class SharedPreferencesViewModel extends androidx.lifecycle.ViewModel {
    private final com.itx.wvsecurit.data.preferences.SharedPreferencesRepository sharedPreferencesRepository = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isGpsTracking;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLogin;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.String> token;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.String> user;
    
    @javax.inject.Inject()
    public SharedPreferencesViewModel(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.preferences.SharedPreferencesRepository sharedPreferencesRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isGpsTracking() {
        return null;
    }
    
    public final void setGpsTracking(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLogin() {
        return null;
    }
    
    public final void setLogin(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getToken() {
        return null;
    }
    
    public final void setToken(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    public final void setIsGpsTracking(boolean value) {
    }
    
    public final void setIsLogin(boolean value) {
    }
    
    public final void setToken(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void onCreate() {
    }
}