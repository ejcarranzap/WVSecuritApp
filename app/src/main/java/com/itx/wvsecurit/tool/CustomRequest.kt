package com.itx.common.jcdata

import com.google.gson.annotations.SerializedName

data class CustomRequest<T> (
        @SerializedName("data")
        var data: T?
)