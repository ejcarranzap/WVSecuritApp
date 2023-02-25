package com.itx.common.jcdata

import com.google.gson.annotations.SerializedName

data class CustomResponse<T> (
    @SerializedName("code")
    var statusCode: Int?,

    @SerializedName("msg")
    var msg: String?,

    @SerializedName("success")
    var success: String?,

    @SerializedName("data")
    var data: T
)