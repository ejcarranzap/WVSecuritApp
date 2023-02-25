package com.itx.wvsecurit.di

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Looper
import android.provider.Settings
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationAvailability
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.itx.wvsecurit.service.LocationService
import java.lang.ref.WeakReference


object LocationManager {
 private const val TAG = "LocationManager"

 private lateinit var activity: WeakReference<Activity>
 private lateinit var locationRequest: LocationRequest
 private lateinit var onUpdateLocation: WeakReference<(latitude: Double, longitude: Double) -> Unit>

 private var interval: Long = 2000
    private var fastestInterval: Long = 1000
    private var priority: Int = 100

    private val locationCallBack = object: LocationCallback(){
        override fun onLocationAvailability(locationAvailability: LocationAvailability) {
            System.out.println("$TAG locationAvailability ${locationAvailability.isLocationAvailable}")

            if(!locationAvailability.isLocationAvailable){
                activity.get()?.let {
                    //go to open gps
                    val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    it.startActivity(intent)
                    //and stop location

                }
            }

            super.onLocationAvailability(locationAvailability)
        }

        override fun onLocationResult(locationResult: LocationResult) {
            super.onLocationResult(locationResult)

            onUpdateLocation.get()?.invoke(locationResult.lastLocation!!.latitude, locationResult.lastLocation!!.longitude)
        }
    }

    fun request(withForegroundService: Boolean,onUpdateLocation: (latitude: Double, longitude: Double) -> Unit){
        this.onUpdateLocation = WeakReference(onUpdateLocation)

        if(withForegroundService){
            requestWithService()
        }else{
            requestWithoutService()
        }

        requestWithoutService()
    }

    private fun requestWithService(){
        activity.get()?.let { context ->
            LocationService.startLocationWithService(context, delegate = {
                serviceContext ->
                if(ActivityCompat.checkSelfPermission(
                        serviceContext,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        serviceContext,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ){
                    Toast.makeText(serviceContext, "need permission", Toast.LENGTH_SHORT).show()
                    return@startLocationWithService
                }
            })
        }
    }

    private fun requestWithoutService(){
        activity.get()?.let {
            if(ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ){
                Toast.makeText(it, "need permission", Toast.LENGTH_SHORT).show()
                return
            }
            LocationServices.getFusedLocationProviderClient(it).requestLocationUpdates(
                locationRequest, locationCallBack, Looper.getMainLooper()
            )
        }
    }

    fun stop(activity: Activity){
        LocationService.stopLocatingService(activity)
        removeCallback(activity)
    }

    private fun removeCallback(activity: Activity){
        LocationServices.getFusedLocationProviderClient(activity).removeLocationUpdates(
            locationCallBack)
    }

    /*builder pattern*/

    object Builder {
        fun build(): Builder {
            return this
        }

        fun setInterval(interval: Long): Builder {
            LocationManager.interval = interval
            return this
        }

        fun setFastestInterval(fastestInterval: Long): Builder {
            LocationManager.fastestInterval = fastestInterval
            return this
        }

        fun setPriority(priority: Int): Builder{
            LocationManager.priority = priority
            return this
        }

        fun create(activity: Activity): LocationManager {
            LocationManager.activity = WeakReference(activity)
            locationRequest = LocationRequest.create().setInterval(interval).setFastestInterval(
                fastestInterval).setPriority(priority)
            return LocationManager
        }
    }
}

