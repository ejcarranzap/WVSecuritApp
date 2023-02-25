package com.itx.wvsecurit.data.database

import com.itx.wvsecurit.data.database.dao.GeoAlertTypeDao
import com.itx.wvsecurit.data.database.entities.GeoAlertTypeEntity
import javax.inject.Inject

class GeoAlertTypeRepository @Inject constructor(private val dao: GeoAlertTypeDao) {
    suspend fun getAll(): List<GeoAlertTypeEntity> {
        val response = dao.getAll()
        return response
    }

    suspend fun getAllPend(): List<GeoAlertTypeEntity> {
        val response = dao.getAllPend()
        return response
    }

    suspend fun insert(entity: GeoAlertTypeEntity){
        dao.insert(entity)
    }

    suspend fun updateSync(sync:Int, id: Int){
        dao.update(sync, id)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }
}