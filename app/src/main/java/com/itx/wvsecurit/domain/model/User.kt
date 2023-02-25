package com.itx.wvsecurit.domain.model

import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("idusuario")
    lateinit var idusuario: String

    @SerializedName("username")
    lateinit var username: String

    @SerializedName("password")
    lateinit var password: String

    @SerializedName("image")
    lateinit var image: String

    @SerializedName("nombreusuario")
    lateinit var nombreusuario: String
}