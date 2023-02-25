package com.itx.wvsecurit.data.database.entities

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class SendMailEntity(
    @SerializedName("from")
    @ColumnInfo( name = "from") val from:String? = null,

    @SerializedName("to")
    @ColumnInfo( name = "to") val to:String? = null,

    @SerializedName("subject")
    @ColumnInfo( name = "subject") val subject:String? = null,

    @SerializedName("text")
    @ColumnInfo( name = "text") val text:String? = null,

    @SerializedName("html")
    @ColumnInfo( name = "html") val html:String? = null,
)
