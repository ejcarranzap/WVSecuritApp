package com.itx.wvsecurit.data.network

import com.itx.common.jcdata.CustomResponse
import com.itx.wvsecurit.data.database.entities.SegIncidentTypeEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SegIncidentTypeApiClient {
    @POST("tbl_ad_segc_incident_type")
    fun post(@Body request: SegIncidentTypeEntity): Call<CustomResponse<List<SegIncidentTypeEntity>>>
}