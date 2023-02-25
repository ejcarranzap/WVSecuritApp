package com.itx.wvsecurit.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "seg_incident_type")
data class SegIncidentTypeEntity(
    @PrimaryKey
    @SerializedName("Id_incident_type")
    @ColumnInfo( name = "Id_incident_type") val Id_incident_type:Int? = null,


    @SerializedName("action")
    @ColumnInfo( name = "action") val action:String? = null,

    @SerializedName("rawprm")
    @ColumnInfo( name = "rawprm") val rawprm:String? = null,


    @SerializedName("Id_incident_group")
    @ColumnInfo( name = "Id_incident_group") val Id_incident_group:Int? = null,

    @SerializedName("code")
    @ColumnInfo( name = "code") val code:String? = null,

    @SerializedName("name")
    @ColumnInfo( name = "name") val name:String? = null,

    @SerializedName("description")
    @ColumnInfo( name = "description") val description:String? = null,

    @SerializedName("user_mod")
    @ColumnInfo( name = "user_mod") val user_mod:String? = null,

    @SerializedName("date_mod")
    @ColumnInfo( name = "date_mod") val date_mod:Date? = null,

    @SerializedName("active")
    @ColumnInfo( name = "active") val active:Int? = null,

    @SerializedName("sync")
    @ColumnInfo(name = "sync") val sync: Int? = null

    ) {
    override fun toString(): String {
        return "$code - $name"
    }
}
