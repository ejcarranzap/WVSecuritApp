package com.itx.wvsecurit.data.network;

import com.itx.wvsecurit.data.constants.Constants;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/itx/wvsecurit/data/network/FileDownloadApiClient;", "", "get", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "file", "", "app_debug"})
public abstract interface FileDownloadApiClient {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "http://192.168.1.11:3081/uploads/{file}")
    public abstract retrofit2.Call<okhttp3.ResponseBody> get(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "file")
    java.lang.String file);
}