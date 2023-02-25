package com.itx.wvsecurit.data.database.dao

import androidx.room.*
import com.itx.wvsecurit.data.database.entities.GeoLocationEntity

@Dao
interface GeoLocationDao {
    @Query("SELECT * FROM geo_location ORDER BY date_mod DESC")
    suspend fun getAll():List<GeoLocationEntity>

    @Query("SELECT * FROM geo_location WHERE sync = 0 ORDER BY date_mod DESC")
    suspend fun getAllPend():List<GeoLocationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(geoLocation: List<GeoLocationEntity>)

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insert(geoLocationEntity: GeoLocationEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(geoLocationEntity: GeoLocationEntity)

    @Query("UPDATE geo_location SET sync = :sync WHERE Id_geo_location =:id")
    fun update(sync: Int, id: Int)

    @Query("DELETE FROM geo_location")
    suspend fun deleteAll()
}