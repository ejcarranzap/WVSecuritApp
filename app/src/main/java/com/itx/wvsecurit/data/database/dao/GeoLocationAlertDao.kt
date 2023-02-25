package com.itx.wvsecurit.data.database.dao

import androidx.room.*
import com.itx.wvsecurit.data.database.entities.GeoLocationAlertEntity

@Dao
interface GeoLocationAlertDao {
    @Query("SELECT * FROM geo_location_alert ORDER BY date_mod DESC")
    suspend fun getAll():List<GeoLocationAlertEntity>

    @Query("SELECT * FROM geo_location_alert WHERE sync = 0 ORDER BY date_mod DESC")
    suspend fun getAllPend():List<GeoLocationAlertEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<GeoLocationAlertEntity>)

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insert(record: GeoLocationAlertEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(record: GeoLocationAlertEntity)

    @Query("UPDATE geo_location_alert SET sync = :sync WHERE Id_geo_location_alert =:id")
    fun update(sync: Int, id: Int)

    @Query("DELETE FROM geo_location_alert")
    suspend fun deleteAll()
}