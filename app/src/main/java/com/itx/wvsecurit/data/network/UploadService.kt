package com.itx.wvsecurit.data.network


import com.itx.common.jcdata.CustomResponse
import com.itx.wvsecurit.data.constants.Constants
import com.itx.wvsecurit.data.database.entities.FileEntity
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface UploadService {
    @Multipart
    @POST(Constants.IP + "upload")
    fun uploadImages(@Part file: MultipartBody.Part): Call<CustomResponse<FileEntity>>
}