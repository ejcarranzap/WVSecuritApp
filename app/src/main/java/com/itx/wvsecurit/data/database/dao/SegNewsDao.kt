package com.itx.wvsecurit.data.database.dao

import androidx.room.*
import com.itx.wvsecurit.data.database.entities.SegNewsEntity

@Dao
interface SegNewsDao {
    @Query("SELECT * FROM seg_news ORDER BY date_mod DESC")
    suspend fun getAll():List<SegNewsEntity>

    @Query("SELECT * FROM seg_news WHERE sync = 0 ORDER BY date_mod DESC")
    suspend fun getAllPend():List<SegNewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<SegNewsEntity>)

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insert(list: SegNewsEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(record: SegNewsEntity)

    @Query("UPDATE seg_news SET sync = :sync WHERE Id_news =:id")
    fun update(sync: Int, id: Int)

    @Query("DELETE FROM seg_news")
    suspend fun deleteAll()
}