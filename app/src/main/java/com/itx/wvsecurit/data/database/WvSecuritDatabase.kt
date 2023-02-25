package com.itx.wvsecurit.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.itx.wvsecurit.data.database.dao.*
import com.itx.wvsecurit.data.database.entities.*

@Database(entities = [GeoLocationEntity::class,
    SegIncidentTypeEntity::class,SegIncidentEntity::class, GeoAlertTypeEntity::class,
                     GeoLocationAlertEntity::class,SegNewsEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class WvSecuritDatabase: RoomDatabase(){
    abstract fun getGeoLocationDao(): GeoLocationDao
    abstract fun getSegIncidentTypeDao(): SegIncidentTypeDao
    abstract fun getSegIncidentDao(): SegIncidentDao
    abstract fun getGeoAlertTypeDao(): GeoAlertTypeDao
    abstract fun getGeoLocationAlertDao(): GeoLocationAlertDao
    abstract fun getSegNewsDao(): SegNewsDao

}