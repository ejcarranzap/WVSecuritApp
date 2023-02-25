package com.itx.wvsecurit.data.database

import com.itx.wvsecurit.data.database.dao.GeoLocationAlertDao
import com.itx.wvsecurit.data.database.entities.GeoLocationAlertEntity
import javax.inject.Inject

class GeoLocationAlertRepository @Inject constructor(private val dao: GeoLocationAlertDao) {
    suspend fun getAllGeoLocation(): List<GeoLocationAlertEntity> {
        val response = dao.getAll()
        return response
    }

    suspend fun getAllGeoLocationPend(): List<GeoLocationAlertEntity> {
        val response = dao.getAllPend()
        return response
    }

    suspend fun insertGeoLocation(geoLocationEntity: GeoLocationAlertEntity){
        dao.insert(geoLocationEntity)
    }

    suspend fun updateGeoLocationSync(sync:Int, id: Int){
        dao.update(sync, id)
    }
}