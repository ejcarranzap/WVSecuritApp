package com.itx.wvsecurit.data.database

import com.itx.wvsecurit.data.database.dao.SegNewsDao
import com.itx.wvsecurit.data.database.entities.SegNewsEntity
import javax.inject.Inject

class SegNewsRepository @Inject constructor(private val dao: SegNewsDao) {
    suspend fun getAll(): List<SegNewsEntity> {
        val response = dao.getAll()
        return response
    }

    suspend fun getAllPend(): List<SegNewsEntity> {
        val response = dao.getAllPend()
        return response
    }

    suspend fun insert(entity: SegNewsEntity){
        dao.insert(entity)
    }

    suspend fun updateSync(sync:Int, id: Int){
        dao.update(sync, id)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }
}