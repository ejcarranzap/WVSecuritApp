package com.itx.wvsecurit.tool

import com.itx.wvsecurit.data.constants.Constants
import com.itx.wvsecurit.data.preferences.SharedPreferencesRepository
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okio.Buffer
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MyInterceptor @Inject constructor(private var sharedPreferencesRepository: SharedPreferencesRepository): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return try {
            var original: Request = chain.request()
            var builder: Request.Builder = original.newBuilder()
            var request = builder.build()
            var body = request.body

            if(body != null && body!!.contentType()!!.toString().contains("application/json")) {
                val oldBody = request.body
                val buffer = Buffer()
                oldBody!!.writeTo(buffer)
                val strOldBody: String = buffer.readUtf8()
                buffer.clear()
                buffer.close()

                val mediaType: MediaType? = "application/json; charset=UTF-8".toMediaTypeOrNull()

                val json = JSONObject(strOldBody)


                if (json.has("action")) {
                    if (json.getString("action") != "S") {
                        val prms = JSONObject()
                        prms.accumulate("user", sharedPreferencesRepository.user)
                        prms.accumulate("date", "2023-02-18 22:03:00")
                        json.accumulate("extra", prms)
                    } else {
                        json.accumulate("extra", JSONObject())
                    }
                }


                body = RequestBody.create(
                    mediaType,
                    json.toString()
                )
            }

            builder.method(original.method, body)
            builder.header("Authorization", "bearer " + sharedPreferencesRepository.token)

            request = builder.build()
            var response: Response = chain.proceed(request)

            if (response.code != 200 && response.code != 0) {
                /*var report = Report(Throwable(response.message))
            report.deliver()*/
                System.out.println("MyInterceptor Error: ${response.code} ${response.message}")
                throw java.lang.Exception(response.message)
            }

            response
        } catch (ex: Exception){

            throw ex
        }
    }
}

