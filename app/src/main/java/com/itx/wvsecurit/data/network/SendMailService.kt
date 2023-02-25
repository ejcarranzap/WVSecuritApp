package com.itx.wvsecurit.data.network

import com.itx.common.jcdata.CustomResponse
import com.itx.wvsecurit.data.constants.Constants
import com.itx.wvsecurit.data.database.entities.SendMailEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SendMailService {
    @POST(Constants.MAIN_URL + "send_emailB")
    fun post(@Body request: SendMailEntity): Call<CustomResponse<List<SendMailEntity>>>
}