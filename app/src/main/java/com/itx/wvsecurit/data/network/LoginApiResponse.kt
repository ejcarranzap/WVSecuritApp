package com.itx.wvsecurit.data.network

import com.google.gson.annotations.SerializedName
import com.itx.wvsecurit.domain.model.User

data class LoginApiResponse (
    @SerializedName("code")
    var code: String?,

    @SerializedName("msg")
    var msg: String?,

    @SerializedName("success")
    var success: Boolean?,

    @SerializedName("token")
    var token: String?,

    @SerializedName("username")
    var username: String?
){
    constructor(): this(null,null,null,null,null)
}