package com.itx.wvsecurit.domain.usecase

import com.itx.common.jcdata.CustomResponse
import com.itx.wvsecurit.data.database.entities.SegIncidentTypeEntity
import com.itx.wvsecurit.data.network.SegIncidentTypeApiClient
import retrofit2.Call
import javax.inject.Inject

class GetSegIncidentTypeUseCase @Inject constructor(private val segIncidentTypeApiClient: SegIncidentTypeApiClient){
    operator fun invoke(): Call<CustomResponse<List<SegIncidentTypeEntity>>> {
        return segIncidentTypeApiClient.post(SegIncidentTypeEntity(null,"S",null))
    }
}