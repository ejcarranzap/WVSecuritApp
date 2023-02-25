package com.itx.wvsecurit.data.database

import com.itx.wvsecurit.data.database.dao.GeoLocationDao
import com.itx.wvsecurit.data.database.entities.GeoLocationEntity
import javax.inject.Inject

class GeoLocationRepository @Inject constructor(private val geoLocationDao: GeoLocationDao) {
    suspend fun getAllGeoLocation(): List<GeoLocationEntity> {
        val response = geoLocationDao.getAll()
        return response
    }

    suspend fun getAllGeoLocationPend(): List<GeoLocationEntity> {
        val response = geoLocationDao.getAllPend()
        return response
    }

    suspend fun insertGeoLocation(geoLocationEntity: GeoLocationEntity){
        geoLocationDao.insert(geoLocationEntity)
    }

    suspend fun updateGeoLocationSync(sync:Int, id: Int){
        geoLocationDao.update(sync, id)
    }
}