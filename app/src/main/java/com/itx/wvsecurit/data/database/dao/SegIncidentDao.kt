package com.itx.wvsecurit.data.database.dao

import androidx.room.*
import com.itx.wvsecurit.data.database.entities.SegIncidentEntity

@Dao
interface SegIncidentDao {
    @Query("SELECT * FROM seg_incident ORDER BY date_mod DESC")
    suspend fun getAll():List<SegIncidentEntity>

    @Query("SELECT * FROM seg_incident WHERE sync = 0 ORDER BY date_mod DESC")
    suspend fun getAllPend():List<SegIncidentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(segIncident: List<SegIncidentEntity>)

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insert(segIncident: SegIncidentEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(segIncident: SegIncidentEntity)

    @Query("UPDATE seg_incident SET sync = :sync WHERE Id_incident =:id")
    fun update(sync: Int, id: Int)

    @Query("DELETE FROM seg_incident")
    suspend fun deleteAll()
}