package com.itx.wvsecurit.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.itx.wvsecurit.ui.view.MainActivity
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.components.SingletonComponent
import java.lang.ref.WeakReference
import java.text.SimpleDateFormat
import java.util.*

@Module
@InstallIn(ServiceComponent::class)
class MainService : Service() {
    companion object {
        var isMainServiceRunning = false

        private const val MAIN_SERVICE_ID = 888
        private const val ACTION_START_MAIN_SERVICE = "startMainService"
        private const val ACTION_STOP_MAIN_SERVICE = "stopMainService"
        private var intervalTask: Long = 2000

        private lateinit var delegate: WeakReference<(serviceContext: Service) -> Unit>
        private lateinit var delegateCallback: WeakReference<(msg: String) -> Unit>
        fun startMainWithService(
            context: Context,
            channelId: String = "main_notification_channel_id",
            iconResource: Int = com.itx.wvsecurit.R.mipmap.ic_launcher,
            title: String = "Main Service",
            defaults: Int = NotificationCompat.DEFAULT_ALL,
            contentText: String = "Main Service content",
            versionOName: String = "Main Service name",
            versionODescription: String = "Main Service description",
            delegate: (serviceContext: Service) -> Unit,
            callBack: (msg: String) -> Unit,
            interval: Long
        ) {
            this.delegate = WeakReference(delegate)
            this.delegateCallback = WeakReference(callBack)
            this.intervalTask = interval
            Intent(context, MainService::class.java).apply {
                this.action = ACTION_START_MAIN_SERVICE
                val bundle = Bundle()
                bundle.putString("channelId", channelId)
                bundle.putInt("iconResource", iconResource)
                bundle.putString("title", title)
                bundle.putInt("defaults", defaults)
                bundle.putString("contentText", contentText)
                bundle.putString("versionOName", versionOName)
                bundle.putString("versionODescription", versionODescription)

                this.putExtra("bundle", bundle)
                context.startService(this)
            }
        }

        fun stopMainWithService(context: Context) {
            Intent(context, MainService::class.java).apply {
                this.action = ACTION_STOP_MAIN_SERVICE
                context.startActivity(this)
            }
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        Log.d(TAG, "Servicio creado")
    }

    private var hasStarted = false

    var timerTask: TimerTask? = null
    var timer: Timer? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "Servicio iniciado...");

        intent?.let {
            it.action?.let { action ->
                if (ACTION_START_MAIN_SERVICE == action) {
                    val bundle = it.getBundleExtra("bundle")!!
                    startMainService(
                        bundle["channelId"] as String,
                        bundle["iconResource"] as Int,
                        bundle["title"] as String,
                        bundle["defaults"] as Int,
                        bundle["contentText"] as String,
                        bundle["versionOName"] as String,
                        bundle["versionODescription"] as String
                    )
                } else if (ACTION_STOP_MAIN_SERVICE == action) {
                    stopMainService()
                }
            }
        }

        /*if (timer == null) {*/
            if(timer != null){
                timer!!.cancel()
            }

            timer = Timer()
            timerTask = object : TimerTask() {
                override fun run() {
                    try {
                        System.out.println("RUN TIMER TASK SERVICIO MAIN")
                        val c = Calendar.getInstance()
                        val sdf = SimpleDateFormat("dd MMMM yyyy   - hh mm ss", Locale.FRENCH)
                        val strDate: String = sdf.format(c.time)

                        if (!hasStarted) {
                            hasStarted = true
                            val msg =
                                "TEST SERVICIO WVSECURIT MENSAJE DE SERVICIO CADA 10 SEGUNDOS ${strDate}"
                            delegateCallback.get()?.invoke(msg)
                            hasStarted = false

                            //addGeoLocationUseCase.invoke(GeoLocationEntity("","0","0","Y",Date(),"",Date(),"",0.0,0.0,"Test From Service",0))

                        }
                    } catch (ex: Exception) {
                        System.out.println("RUN TIMER TASK SERVICIO MAIN " + ex.message)
                    }
                }
            }
        /*}*/

        timer!!.scheduleAtFixedRate(timerTask, 0, intervalTask)

        return super.onStartCommand(intent, flags, startId)
        //return START_NOT_STICKY
    }


    private fun startMainService(
        channelId: String, iconResource: Int, title: String,
        defaults: Int, contentText: String,
        versionOName: String, versionODescription: String
    ) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //val intent = Intent()
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            applicationContext,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val builder = NotificationCompat.Builder(applicationContext, channelId)

        builder.setSmallIcon(iconResource)
        builder.setContentTitle(title)
        builder.setDefaults(defaults)
        builder.setContentText(contentText)
        builder.setContentIntent(pendingIntent)
        builder.setAutoCancel(false)
        builder.priority = NotificationCompat.PRIORITY_MAX

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel =
                NotificationChannel(channelId, versionOName, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.description = versionODescription
            notificationManager.createNotificationChannel(notificationChannel)
        }

        delegate.get()?.invoke(this)

        startForeground(MAIN_SERVICE_ID, builder.build())
        isMainServiceRunning = true
    }

    private fun stopMainService() {
        isMainServiceRunning = false
        stopForeground(true)
        stopSelf()
    }

}