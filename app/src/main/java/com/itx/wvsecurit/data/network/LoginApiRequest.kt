package com.itx.wvsecurit.data.network

import com.google.gson.annotations.SerializedName

data class LoginApiRequest (
    @SerializedName("ACTION")
    var ACTION: String,
    @SerializedName("IDUSUARIO")
    var IDUSUARIO: Int,
    @SerializedName("Usuario")
    var Usuario: String,
    @SerializedName("Password")
    var Password: String,
    @SerializedName("Ruta")
    var Ruta: String,
    @SerializedName("requestPassword")
    var requestPassword: String
)