package com.itx.wvsecurit.tool

import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.google.android.gms.location.LocationServices
import com.itx.wvsecurit.data.database.GeoLocationRepository
import com.itx.wvsecurit.data.database.entities.GeoLocationEntity
import com.itx.wvsecurit.data.preferences.SharedPreferencesRepository
import com.itx.wvsecurit.domain.usecase.AddGeoLocationUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import retrofit2.awaitResponse
import java.util.Date
import javax.inject.Inject

@AndroidEntryPoint
class LocationService: Service() {
    @Inject lateinit var geoLocationRepository: GeoLocationRepository
    @Inject lateinit var addGeoLocationUseCase: AddGeoLocationUseCase
    @Inject lateinit var sharedPreferencesRepository: SharedPreferencesRepository

    private val serviceScope = CoroutineScope(SupervisorJob()+ Dispatchers.IO)
    private lateinit var locationClient: LocationClient
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        locationClient = DefaultLocationClient(
            applicationContext,
            LocationServices.getFusedLocationProviderClient(applicationContext)
        )
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action) {
            ACTION_START -> start()
            ACTION_STOP -> stop()
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun start(){
        val notification = NotificationCompat.Builder(this, "location")
            .setContentTitle("Tracking location...")
            .setContentText("Location: null")
            .setSmallIcon(com.itx.wvsecurit.R.mipmap.ic_button_panic)
            .setOngoing(true)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        locationClient.getLocationUpdates(15000L)
            .catch {
                e-> e.printStackTrace()
            }.onEach { location ->
                val lat = location.latitude.toString()
                val long = location.longitude.toString()
                val updatedNotification = notification.setContentText(
                    "Location: ($lat, $long)"
                )
                notificationManager.notify(1, updatedNotification.build())

                geoLocationRepository.insertGeoLocation(
                    GeoLocationEntity(
                        0, "I", "",
                        location.latitude, location.longitude, "FROM WVSecuritApp", sharedPreferencesRepository.user,
                        Date(), 1, 0
                    )
                )

                val list = geoLocationRepository.getAllGeoLocationPend()
                for (l in list) {
                    addGeoLocationUseCase.invoke(l).awaitResponse()
                    geoLocationRepository.updateGeoLocationSync(
                        1,
                        l.Id_geo_location!!
                    )
                }
            }.launchIn(serviceScope)

        startForeground(1, notification.build())
    }

    private fun stop(){
        stopForeground(true)
        stopSelf()
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }


    companion object {
        const val ACTION_START = "ACTION_START"
        const val ACTION_STOP = "ACTION_STOP"
    }
}