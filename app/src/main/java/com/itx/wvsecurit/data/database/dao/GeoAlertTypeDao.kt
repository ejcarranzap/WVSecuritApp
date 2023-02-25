package com.itx.wvsecurit.data.database.dao

import androidx.room.*
import com.itx.wvsecurit.data.database.entities.GeoAlertTypeEntity

@Dao
interface GeoAlertTypeDao {
    @Query("SELECT * FROM geo_alert_type ORDER BY date_mod DESC")
    suspend fun getAll():List<GeoAlertTypeEntity>

    @Query("SELECT * FROM geo_alert_type WHERE sync = 0 ORDER BY date_mod DESC")
    suspend fun getAllPend():List<GeoAlertTypeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<GeoAlertTypeEntity>)

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insert(list: GeoAlertTypeEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(record: GeoAlertTypeEntity)

    @Query("UPDATE geo_alert_type SET sync = :sync WHERE Id_alert_type =:id")
    fun update(sync: Int, id: Int)

    @Query("DELETE FROM geo_alert_type")
    suspend fun deleteAll()
}