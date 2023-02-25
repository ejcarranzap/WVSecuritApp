package com.itx.wvsecurit.data.network

import com.itx.common.jcdata.CustomResponse
import com.itx.wvsecurit.data.database.entities.GeoLocationEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface GeoLocationApiClient {
    @POST("tbl_ad_segc_geo_location")
    fun post(@Body request: GeoLocationEntity): Call<CustomResponse<List<GeoLocationEntity>>>
}
