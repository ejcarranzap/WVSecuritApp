package com.itx.wvsecurit.domain.usecase

import com.itx.wvsecurit.data.network.LoginApiClient
import com.itx.wvsecurit.data.network.LoginApiRequest
import com.itx.wvsecurit.data.network.LoginApiResponse
import retrofit2.Call
import javax.inject.Inject

class GetLoginUseCase @Inject constructor(private val loginApiClient: LoginApiClient) {
    operator fun invoke(user: String, password: String): Call<LoginApiResponse> {
        return loginApiClient.login(LoginApiRequest("",0,user, password, "", "0"))
    }
}