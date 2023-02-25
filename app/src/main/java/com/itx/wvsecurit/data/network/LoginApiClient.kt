package com.itx.wvsecurit.data.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiClient {
    @POST("login")
    fun login(@Body loginRequest: LoginApiRequest): Call<LoginApiResponse>
}