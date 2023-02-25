package com.itx.wvsecurit.data.network

import com.itx.common.jcdata.CustomResponse
import com.itx.wvsecurit.data.database.entities.SegIncidentEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SegIncidentApiClient {
    @POST("tbl_ad_segc_incident_app")
    fun post(@Body request: SegIncidentEntity): Call<CustomResponse<List<SegIncidentEntity>>>
}