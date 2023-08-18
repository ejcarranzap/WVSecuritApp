package com.itx.wvsecurit.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.itx.wvsecurit.data.constants.Constants
import com.itx.wvsecurit.data.network.*
import com.itx.wvsecurit.data.preferences.SharedPreferencesRepository
import com.itx.wvsecurit.tool.HttpHeader
import com.itx.wvsecurit.tool.MyInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setDateFormat(Constants.TIME_STAMP_FORMAT)
            .create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(myInterceptor: MyInterceptor, gson: Gson): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.MAIN_URL).addConverterFactory(
            GsonConverterFactory.create(gson)).client(getHttpClient(myInterceptor)).build()
    }

    @Singleton
    @Provides
    fun provideLoginApiClient(retrofit: Retrofit): LoginApiClient {
        return retrofit.create(LoginApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideGeoLocationApiClient(retrofit: Retrofit): GeoLocationApiClient {
        return retrofit.create(GeoLocationApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideGeoLocationAlertApiClient(retrofit: Retrofit): GeoLocationAlertApiClient {
        return retrofit.create(GeoLocationAlertApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideSegIncidentTypeApiClient(retrofit: Retrofit): SegIncidentTypeApiClient {
        return retrofit.create(SegIncidentTypeApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideSegIncidentApiClient(retrofit: Retrofit): SegIncidentApiClient {
        return retrofit.create(SegIncidentApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideSegNewsApiClient(retrofit: Retrofit): SegNewsApiClient {
        return retrofit.create(SegNewsApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideGeoAlertTypeApiClient(retrofit: Retrofit): GeoAlertTypeApiClient {
        return retrofit.create(GeoAlertTypeApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideFileDownloadApiClient(retrofit: Retrofit): FileDownloadApiClient {
        return retrofit.create(FileDownloadApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideUploadService(retrofit: Retrofit): UploadService {
        return retrofit.create(UploadService::class.java)
    }

    @Singleton
    @Provides
    fun provideSendMail(retrofit: Retrofit): SendMailService {
        return retrofit.create(SendMailService::class.java)
    }

    @Provides
    @Singleton
    fun provideMyInterceptor(sharedPreferencesRepository: SharedPreferencesRepository): MyInterceptor {
        return MyInterceptor(sharedPreferencesRepository)
    }


    @Provides
    @Singleton
    fun getHttpClient(myInterceptor: MyInterceptor): OkHttpClient {
        //interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
        return getUnsafeOkHttpClient()!!
            .readTimeout((60 * 1000), TimeUnit.MILLISECONDS)
            .writeTimeout((60 * 1000), TimeUnit.MILLISECONDS)
            .connectTimeout((5 * 1000), TimeUnit.MILLISECONDS)
            .addInterceptor(myInterceptor)
            .build()
    }


    @Provides
    @Singleton
    fun getUnsafeOkHttpClient(): OkHttpClient.Builder? {
        return try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts: Array<TrustManager> = arrayOf<TrustManager>(
                object : X509TrustManager {

                    override fun checkClientTrusted(chain: Array<X509Certificate?>?, authType: String?) {
                    }

                    override fun checkServerTrusted(chain: Array<X509Certificate?>?, authType: String?) {
                    }

                    override fun getAcceptedIssuers(): Array<X509Certificate> {
                        return arrayOf()
                    }
                }
            )

            // Install the all-trusting trust manager
            val sslContext: SSLContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())

            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory: SSLSocketFactory = sslContext.socketFactory

            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier { _, _ -> true }
            builder
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}