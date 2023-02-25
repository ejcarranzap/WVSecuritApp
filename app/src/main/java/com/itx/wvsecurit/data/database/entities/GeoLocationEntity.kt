package com.itx.wvsecurit.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "geo_location")
data class GeoLocationEntity(
    @PrimaryKey
    @SerializedName("Id_geo_location")
    @ColumnInfo( name = "Id_geo_location") val Id_geo_location:Int? = null,


    @SerializedName("action")
    @ColumnInfo( name = "action") val action:String? = null,

    @SerializedName("rawprm")
    @ColumnInfo( name = "rawprm") val rawprm:String? = null,


    @SerializedName("latitude")
    @ColumnInfo( name = "latitude") val latitude:Double? = null,

    @SerializedName("longitude")
    @ColumnInfo( name = "longitude") val longitude:Double? = null,

    @SerializedName("description")
    @ColumnInfo( name = "description") val description:String? = null,

    @SerializedName("user_mod")
    @ColumnInfo( name = "user_mod") val user_mod:String? = null,

    @SerializedName("date_mod")
    @ColumnInfo( name = "date_mod") val date_mod:Date?? = null,

    @SerializedName("active")
    @ColumnInfo( name = "active") val active:Int? = null,

    @SerializedName("sync")
    @ColumnInfo(name = "sync") val sync: Int? = null

)
