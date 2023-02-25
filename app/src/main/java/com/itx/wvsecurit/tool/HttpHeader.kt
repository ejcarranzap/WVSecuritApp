package com.itx.wvsecurit.tool

import com.google.gson.annotations.SerializedName

data class HttpHeader(
        @SerializedName("name")
        var name: String,
        @SerializedName("value")
        var value: String
)