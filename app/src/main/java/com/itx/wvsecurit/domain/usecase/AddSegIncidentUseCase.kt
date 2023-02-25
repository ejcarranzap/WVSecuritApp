package com.itx.wvsecurit.domain.usecase

import com.itx.common.jcdata.CustomResponse
import com.itx.wvsecurit.data.database.entities.SegIncidentEntity
import com.itx.wvsecurit.data.network.SegIncidentApiClient
import retrofit2.Call
import javax.inject.Inject

class AddSegIncidentUseCase @Inject constructor(private val segIncidentApiClient: SegIncidentApiClient) {
    operator fun invoke(obj: SegIncidentEntity): Call<CustomResponse<List<SegIncidentEntity>>> {
        return segIncidentApiClient.post(obj)
    }
}