package com.itx.wvsecurit.data.database.dao

import androidx.room.*
import com.itx.wvsecurit.data.database.entities.SegIncidentTypeEntity

@Dao
interface SegIncidentTypeDao {
    @Query("SELECT * FROM seg_incident_type ORDER BY date_mod DESC")
    suspend fun getAll():List<SegIncidentTypeEntity>

    @Query("SELECT * FROM seg_incident_type WHERE sync = 0 ORDER BY date_mod DESC")
    suspend fun getAllPend():List<SegIncidentTypeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(segIncidentType: List<SegIncidentTypeEntity>)

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insert(segIncidentType: SegIncidentTypeEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(segIncidentType: SegIncidentTypeEntity)

    @Query("UPDATE seg_incident_type SET sync = :sync WHERE Id_incident_type =:id")
    fun update(sync: Int, id: Int)

    @Query("DELETE FROM seg_incident_type")
    suspend fun deleteAll()
}