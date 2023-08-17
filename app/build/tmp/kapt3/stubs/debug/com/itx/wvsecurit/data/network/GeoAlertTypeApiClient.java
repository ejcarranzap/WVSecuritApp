package com.itx.wvsecurit.data.network;

import com.itx.common.jcdata.CustomResponse;
import com.itx.wvsecurit.data.database.entities.GeoAlertTypeEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\'\u00a8\u0006\b"}, d2 = {"Lcom/itx/wvsecurit/data/network/GeoAlertTypeApiClient;", "", "post", "Lretrofit2/Call;", "Lcom/itx/common/jcdata/CustomResponse;", "", "Lcom/itx/wvsecurit/data/database/entities/GeoAlertTypeEntity;", "request", "app_debug"})
public abstract interface GeoAlertTypeApiClient {
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.POST(value = "tbl_ad_segc_geo_alert_type")
    public abstract retrofit2.Call<com.itx.common.jcdata.CustomResponse<java.util.List<com.itx.wvsecurit.data.database.entities.GeoAlertTypeEntity>>> post(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.itx.wvsecurit.data.database.entities.GeoAlertTypeEntity request);
}