package com.itx.wvsecurit.data.network

import com.itx.common.jcdata.CustomResponse
import com.itx.wvsecurit.data.database.entities.GeoAlertTypeEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface GeoAlertTypeApiClient {
    @POST("tbl_ad_segc_geo_alert_type")
    fun post(@Body request: GeoAlertTypeEntity): Call<CustomResponse<List<GeoAlertTypeEntity>>>
}