package com.itx.wvsecurit.data.database

import com.itx.wvsecurit.data.database.dao.SegIncidentDao
import com.itx.wvsecurit.data.database.entities.SegIncidentEntity
import javax.inject.Inject

class SegIncidentRepository @Inject constructor(private val segIncidentDao: SegIncidentDao) {
    suspend fun getAll(): List<SegIncidentEntity> {
        val response = segIncidentDao.getAll()
        return response
    }

    suspend fun getAllPend(): List<SegIncidentEntity> {
        val response = segIncidentDao.getAllPend()
        return response
    }

    suspend fun insert(addIncidentEntity: SegIncidentEntity){
        segIncidentDao.insert(addIncidentEntity)
    }

    suspend fun updateSync(sync:Int, id: Int){
        segIncidentDao.update(sync, id)
    }

    suspend fun deleteAll(){
        segIncidentDao.deleteAll()
    }

}