package com.itx.wvsecurit.tool;

import com.itx.wvsecurit.data.constants.Constants;
import com.itx.wvsecurit.data.preferences.SharedPreferencesRepository;
import okio.Buffer;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/itx/wvsecurit/tool/MyInterceptor;", "Lokhttp3/Interceptor;", "sharedPreferencesRepository", "Lcom/itx/wvsecurit/data/preferences/SharedPreferencesRepository;", "(Lcom/itx/wvsecurit/data/preferences/SharedPreferencesRepository;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_debug"})
@javax.inject.Singleton()
public final class MyInterceptor implements okhttp3.Interceptor {
    private com.itx.wvsecurit.data.preferences.SharedPreferencesRepository sharedPreferencesRepository;
    
    @javax.inject.Inject()
    public MyInterceptor(@org.jetbrains.annotations.NotNull()
    com.itx.wvsecurit.data.preferences.SharedPreferencesRepository sharedPreferencesRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor.Chain chain) {
        return null;
    }
}