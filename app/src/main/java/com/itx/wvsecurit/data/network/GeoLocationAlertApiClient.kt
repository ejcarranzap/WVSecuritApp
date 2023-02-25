package com.itx.wvsecurit.data.network

import com.itx.common.jcdata.CustomResponse
import com.itx.wvsecurit.data.database.entities.GeoLocationAlertEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface GeoLocationAlertApiClient {
    @POST("tbl_ad_segc_geo_location_alert")
    fun post(@Body request: GeoLocationAlertEntity): Call<CustomResponse<List<GeoLocationAlertEntity>>>
}
