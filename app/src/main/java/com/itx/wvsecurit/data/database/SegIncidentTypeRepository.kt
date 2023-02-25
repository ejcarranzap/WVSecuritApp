package com.itx.wvsecurit.data.database

import com.itx.wvsecurit.data.database.dao.SegIncidentTypeDao
import com.itx.wvsecurit.data.database.entities.SegIncidentTypeEntity
import javax.inject.Inject

class SegIncidentTypeRepository @Inject constructor(private val segIncidentTypeDao: SegIncidentTypeDao) {
    suspend fun getAll(): List<SegIncidentTypeEntity> {
        val response = segIncidentTypeDao.getAll()
        return response
    }

    suspend fun getAllPend(): List<SegIncidentTypeEntity> {
        val response = segIncidentTypeDao.getAllPend()
        return response
    }

    suspend fun insert(addIncidentEntity: SegIncidentTypeEntity){
        segIncidentTypeDao.insert(addIncidentEntity)
    }

    suspend fun updateSync(sync:Int, id: Int){
        segIncidentTypeDao.update(sync, id)
    }

    suspend fun deleteAll(){
        segIncidentTypeDao.deleteAll()
    }
}