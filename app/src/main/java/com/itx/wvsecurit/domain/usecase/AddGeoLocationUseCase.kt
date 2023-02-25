package com.itx.wvsecurit.domain.usecase

import android.widget.Toast
import com.itx.common.jcdata.CustomResponse
import com.itx.wvsecurit.data.database.entities.GeoLocationEntity
import com.itx.wvsecurit.data.network.GeoLocationApiClient
import retrofit2.Call
import javax.inject.Inject

class AddGeoLocationUseCase @Inject constructor(private val geoLocationApiClient: GeoLocationApiClient) {
    operator fun invoke(obj: GeoLocationEntity): Call<CustomResponse<List<GeoLocationEntity>>> {
            return geoLocationApiClient.post(obj)
    }
}