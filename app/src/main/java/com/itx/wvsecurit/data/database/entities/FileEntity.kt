package com.itx.wvsecurit.data.database.entities

import com.google.gson.annotations.SerializedName

data class FileEntity (
    @SerializedName("filename") val filename: String,
)