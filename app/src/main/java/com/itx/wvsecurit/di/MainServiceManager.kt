package com.itx.wvsecurit.di

import android.app.Activity
import com.itx.wvsecurit.service.LocationService
import com.itx.wvsecurit.service.MainService
import java.lang.ref.WeakReference

object MainServiceManager {
    private lateinit var onUpdateTask: WeakReference<(msg: String) -> Unit?>
    private lateinit var activity: WeakReference<Activity>


    private var interval: Long = 2000

    private fun requestWithService(){
        activity.get()?.let { context ->
            MainService.startMainWithService(context, interval = interval, delegate = {

            }, callBack = { msg ->
                this.onUpdateTask.get()?.invoke(msg)
            })
        }
    }

    fun request(onUpdateTask: (msg: String) -> Unit){
        //if(this.onUpdateTask != null && this.onUpdateTask.get() != null) this.onUpdateTask.clear()
        this.onUpdateTask = WeakReference(onUpdateTask)
        requestWithService()
    }

    fun stop(activity: Activity){
        MainService.stopMainWithService(activity)
    }

    object Builder {
        fun setInterval(interval: Long): MainServiceManager.Builder {
            MainServiceManager.interval = interval
            return this
        }
        fun create(activity: Activity): MainServiceManager {
            MainServiceManager.activity = WeakReference(activity)
            return MainServiceManager
        }
    }
}