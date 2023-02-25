package com.itx.wvsecurit.data.network

import com.itx.wvsecurit.data.constants.Constants
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FileDownloadApiClient {
    @GET(Constants.UPLOADS_URL + "{file}")
    fun get(@Path("file") file: String): Call<ResponseBody>
}