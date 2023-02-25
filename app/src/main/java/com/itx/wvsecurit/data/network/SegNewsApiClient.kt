package com.itx.wvsecurit.data.network

import com.itx.common.jcdata.CustomResponse
import com.itx.wvsecurit.data.database.entities.SegNewsEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SegNewsApiClient {
    @POST("tbl_ad_segc_news")
    fun post(@Body request: SegNewsEntity): Call<CustomResponse<List<SegNewsEntity>>>
}