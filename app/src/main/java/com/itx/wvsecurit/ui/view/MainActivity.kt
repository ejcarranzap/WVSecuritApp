package com.itx.wvsecurit.ui.view

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.itx.wvsecurit.R
import com.itx.wvsecurit.data.constants.Constants
import com.itx.wvsecurit.data.database.*
import com.itx.wvsecurit.data.database.entities.GeoAlertTypeEntity
import com.itx.wvsecurit.data.database.entities.GeoLocationAlertEntity
import com.itx.wvsecurit.data.database.entities.GeoLocationEntity
import com.itx.wvsecurit.data.database.entities.SendMailEntity
import com.itx.wvsecurit.data.network.GeoAlertTypeApiClient
import com.itx.wvsecurit.data.network.GeoLocationAlertApiClient
import com.itx.wvsecurit.data.network.SegNewsApiClient
import com.itx.wvsecurit.data.network.SendMailService
import com.itx.wvsecurit.data.preferences.SharedPreferencesRepository
import com.itx.wvsecurit.databinding.ActivityMainBinding
import com.itx.wvsecurit.di.LocationManager
import com.itx.wvsecurit.di.MainServiceManager
import com.itx.wvsecurit.domain.usecase.AddGeoLocationUseCase
import com.itx.wvsecurit.domain.usecase.AddSegIncidentUseCase
import com.itx.wvsecurit.service.LocationService
import com.itx.wvsecurit.tool.ManagePermissions
import com.itx.wvsecurit.tool.MyCustomDialogFragment
import com.itx.wvsecurit.tool.MyDialog
import com.itx.wvsecurit.ui.viewmodel.GeoLocationViewModel
import com.itx.wvsecurit.ui.viewmodel.SharedPreferencesViewModel
import com.nambimobile.widgets.efab.FabOption
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.nav_header.view.tvHeader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {
    private lateinit var managePermissions: ManagePermissions
    private val PermissionsRequestCode = 123
    lateinit var toggle: ActionBarDrawerToggle

    private lateinit var binding: ActivityMainBinding
    @Inject lateinit var sharedPreferencesRepository: SharedPreferencesRepository
    private val sharedPreferencesViewModel: SharedPreferencesViewModel by viewModels()
    private val geoLocationViewModel: GeoLocationViewModel by viewModels()

    @Inject lateinit var geoLocationRepository: GeoLocationRepository
    @Inject lateinit var addGeoLocationUseCase: AddGeoLocationUseCase

    @Inject lateinit var segIncidentRepository: SegIncidentRepository
    @Inject lateinit var addSegIncidentUseCase: AddSegIncidentUseCase

    @Inject lateinit var geoAlertTypeRepository: GeoAlertTypeRepository
    @Inject lateinit var provideGeoAlertTypeApiClient: GeoAlertTypeApiClient

    @Inject lateinit var geoLocationAlertRepository: GeoLocationAlertRepository
    @Inject lateinit var provideGeoLocationAlertApiClient: GeoLocationAlertApiClient

    @Inject lateinit var myDialog: MyDialog
    @Inject lateinit var myCustomDialog: MyCustomDialogFragment

    @Inject lateinit var sendMailService: SendMailService

    private lateinit var fab: FloatingActionButton
    private val onClickListener = View.OnClickListener {
        var fo = (it as FabOption)
        var data = fo.getTag() as GeoAlertTypeEntity

        Toast.makeText(applicationContext,fo.label.text, Toast.LENGTH_SHORT).show()

        SaveGeoLocationAlert(data)
    }

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    @SuppressLint("MissingPermission")
    private fun SaveGeoLocationAlert(data: GeoAlertTypeEntity){
        /*val priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
        val cancellationTokenSource = CancellationTokenSource()

        fusedLocationProviderClient.getCurrentLocation(priority, cancellationTokenSource.token)
            .addOnSuccessListener { it ->
                GlobalScope.launch {
                    withContext(Dispatchers.IO){
                        withContext(Dispatchers.Main){
                            if (it != null){
                                myDialog.show()
                                provideGeoLocationAlertApiClient.post(GeoLocationAlertEntity("",data.geo_alert_type_id,
                                    "0", "0","Y", Date(), sharedPreferencesRepository.user,
                                    Date(), sharedPreferencesRepository.user, it.latitude, it.longitude,data.name, 0)).awaitResponse()
                                myDialog.dismiss()
                            }
                        }
                    }
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(applicationContext, "Oops location failed with exception: $exception", Toast.LENGTH_LONG).show()
            }*/
        val task = fusedLocationProviderClient.lastLocation

        task.addOnSuccessListener {
            lifecycleScope.launch {
            /*GlobalScope.launch {*/
                withContext(Dispatchers.IO){
                    withContext(Dispatchers.Main){
                        if (it != null){
                            myDialog.show()
                            provideGeoLocationAlertApiClient.post(GeoLocationAlertEntity(0,"I","",data.Id_alert_type,
                                it.latitude, it.longitude,data.name, sharedPreferencesRepository.user,
                                Date(), 1, 0)).awaitResponse()
                            myDialog.dismiss()
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        System.out.println("onResume")
        if(sharedPreferencesRepository.gpsTracking)
            requestLocationB()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        System.out.println("onCreate")

        Thread.setDefaultUncaughtExceptionHandler { thread, e ->
            lifecycleScope.launch(Dispatchers.Main) {
                withContext(Dispatchers.Main){
                    Toast.makeText(applicationContext,"Error Main: " + e.message, Toast.LENGTH_LONG).show()
                    myDialog.dismiss()
                }
            }

            /*handleUncaughtException(
                thread,
                e
            )*/
        }

        val builderP = StrictMode.VmPolicy.Builder()
        StrictMode.setVmPolicy(builderP.build())

        val list = listOf<String>(
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

        managePermissions = ManagePermissions(this,list,PermissionsRequestCode)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            managePermissions.checkPermissions()
        }

        sharedPreferencesViewModel.onCreate()
        checkLogin()

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        binding.apply {
            toggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.mnu_notifications -> {
                        Toast.makeText(this@MainActivity, "Notificaciones", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@MainActivity,NewsActivity::class.java)
                        intent.putExtra("seg_news_type_id", 2)
                        startActivity(intent)
                    }
                    R.id.mnu_noticias -> {
                        Toast.makeText(this@MainActivity, "Noticias", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@MainActivity,NewsActivity::class.java)
                        intent.putExtra("seg_news_type_id", 1)
                        startActivity(intent)
                    }
                    R.id.mnu_incidentes -> {
                        Toast.makeText(this@MainActivity, "Incidentes", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@MainActivity,IncidentActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.mnu_salir -> {
                        Toast.makeText(this@MainActivity, "Salir", Toast.LENGTH_SHORT).show()
                        sharedPreferencesViewModel.setIsLogin(false)
                        //requestStopMainService()
                        checkLogin()
                    }
                }
                true
            }
        }

        geoLocationViewModel.geoLocationList.observe(this){
            lifecycleScope.launch {
                withContext(Dispatchers.IO) {
                        val list = geoLocationRepository.getAllGeoLocation()
                        for (l in list){
                            System.out.println("GEO POS ${l.Id_geo_location} ${l.latitude} ${l.longitude} ${l.user_mod} ${l.date_mod}")
                        }
                }

            }

        }

        //binding.tvMain.text = "is location service running ? ${LocationService.isLocationServiceRunning}"
        binding.navView.getHeaderView(0).tvHeader.text = "WVSecuritApp " + Constants.VERSION

        /*binding.tvLocation.setOnClickListener(View.OnClickListener {
            requestLocationB()
            /*requestMainService()*/
        })*/

        fab = findViewById(R.id.fab)
        fab.setOnClickListener {
            myCustomDialog.setFunctionDialog {
                var btn = it.findViewById<Button>(R.id.btnOk)
                var et = it.findViewById<EditText>(R.id.etValue)
                Toast.makeText(applicationContext, btn.text.toString() + " Value: " + et.text.toString(), Toast.LENGTH_LONG).show()
                myCustomDialog.dismissDialog()

                lifecycleScope.launch(Dispatchers.Main) {
                    withContext(Dispatchers.IO) {
                        withContext(Dispatchers.Main){
                            sendMailService.post(SendMailEntity("", "carlos_ordonez@wvi.org",
                                "SEGURIDAD COORPORATIVA (RUTA)","", "<h1>El usuario "+sharedPreferencesRepository.user+",</h1><h3>Solicita seguimiento de ruta por GPS (WSSecuritApp)</h3>")).awaitResponse()
                        }
                    }
                }
            }
            myCustomDialog.setTitleDialog("Alert")
            myCustomDialog.setMsgDialog("Desea notificar el seguimiento?")
            myCustomDialog.setOkBtnText("Notificar")
            myCustomDialog.setCancelBtnText("Cancel")
            myCustomDialog.setShowValueField(false)
            myCustomDialog.showDialog()
            /*myCustomDialog.setTitle("Alerta")
            myCustomDialog.setMsg("Mensaje")*/
            /*myCustomDialog.function = {
                Toast.makeText(applicationContext, "Ok button click", Toast.LENGTH_LONG).show()
            }*/

            sharedPreferencesRepository.gpsTracking = !sharedPreferencesRepository.gpsTracking
            setFabColor()
            if(sharedPreferencesRepository.gpsTracking){
                requestLocationB()
            }else {
                stopLocationB()
                //LocationManager.stop(this@MainActivity)
            }
        }
        setFabColor()


        /*binding.fab1.setOnClickListener(onClickListener)
        binding.fab2.setOnClickListener(onClickListener)
        binding.fab3.setOnClickListener(onClickListener)
        binding.fab4.setOnClickListener(onClickListener)*/

        if(checkLogin()){
            if(sharedPreferencesRepository.gpsTracking)
                requestLocationB()
            /*requestMainService()*/

            loadFabs()
        }
    }

    fun loadFabs() {
        lifecycleScope.launch {

                //Do background tasks...
                //delay(3000)
                withContext(Dispatchers.Main){
                    myDialog.show()
                    var res = provideGeoAlertTypeApiClient.post(GeoAlertTypeEntity(null,"S",null)).awaitResponse()
                    geoAlertTypeRepository.deleteAll()

                    for(r in res.body()!!.data){
                        geoAlertTypeRepository.insert(r)
                    }

                    var id = 1000
                    for (r in geoAlertTypeRepository.getAll()){
                        //var fab = FabOption(binding.fab1.context)
                        var fab = FabOption(binding.eflMain.context)
                        fab.id = id
                        fab.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                        fab.backgroundTintList = ColorStateList.valueOf(getRandomColor())
                        fab.fabOptionIcon = applicationContext.resources.getDrawable(R.drawable.ic_tracking, applicationContext.theme)
                        fab.label.labelText = r.code + " " + r.name
                        fab.label.labelBackgroundColor = Color.BLACK
                        fab.label.labelTextColor = Color.WHITE
                        fab.label.layoutParams = fab.layoutParams
                        fab.setOnClickListener(onClickListener)
                        fab.tag = r
                        binding.eflMain.addView(fab)

                        //binding.fab1.visibility = View.GONE
                        id++
                    }

                    myDialog.dismiss()
                }
            }


    }

    fun getRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }

    fun checkLogin(): Boolean{
        if(sharedPreferencesRepository.isLogin !==  true){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun requestStopMainService(){
        MainServiceManager.stop(this)
    }

    private fun requestMainService(){
        MainServiceManager.Builder.setInterval(5000).create(this).request { msg ->
            try{
                System.out.println("Message from requestMainService: " + msg)
                lifecycleScope.launch {
                    withContext(Dispatchers.IO) {
                        /*withContext(Dispatchers.Main){*/
                        if(sharedPreferencesRepository != null){
                            val list = geoLocationRepository.getAllGeoLocationPend()
                            for (l in list){
                                addGeoLocationUseCase.invoke(l).awaitResponse()
                                geoLocationRepository.updateGeoLocationSync(1, l.Id_geo_location!!)
                            }

                            val list2 = segIncidentRepository.getAllPend()
                            for(l in list2){
                                addSegIncidentUseCase.invoke(l).awaitResponse()
                                segIncidentRepository.updateSync(1, l.Id_incident!!)
                            }

                        }
                        /*}*/
                    }

                }
                //Log.i("MENSAJE: ", msg)
            }catch (e: Exception){
                System.out.println("Error MainServiceManager request" + e.message)
            }

        }
    }

    private fun setFabColor(){
        if(sharedPreferencesRepository.gpsTracking){
            fab.backgroundTintList = ColorStateList.valueOf(Color.GREEN)
        }else{
            fab.backgroundTintList = ColorStateList.valueOf(Color.RED)
        }
    }

    private fun requestLocationB(){
        Intent(applicationContext, com.itx.wvsecurit.tool.LocationService::class.java).apply {
            action = com.itx.wvsecurit.tool.LocationService.ACTION_START
            startService(this)
        }
    }

    private fun stopLocationB(){
        Intent(applicationContext, com.itx.wvsecurit.tool.LocationService::class.java).apply {
            action = com.itx.wvsecurit.tool.LocationService.ACTION_STOP
            startService(this)
        }
    }

    private fun requestLocation(){
            LocationManager.Builder.setInterval(10000).setFastestInterval(10000)
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY).create(this@MainActivity)
                .request(true) { latitude, longitude ->
                    try {
                        val locationString = "$latitude\n$longitude"
                        //binding.tvLocation.text = locationString
                        //binding.tvMain.text = "is location service running ? ${LocationService.isLocationServiceRunning}"

                        lifecycleScope.launch {

                            withContext(Dispatchers.IO) {
                                geoLocationRepository.insertGeoLocation(
                                    GeoLocationEntity(
                                        0, "I", "",
                                        latitude, longitude, "", sharedPreferencesRepository.user,
                                        Date(), 1, 0
                                    )
                                )

                                withContext(Dispatchers.Main) {
                                    geoLocationViewModel.geoLocationList.postValue(
                                        geoLocationRepository.getAllGeoLocation()
                                    )
                                }

                                val list = geoLocationRepository.getAllGeoLocationPend()
                                for (l in list) {
                                    addGeoLocationUseCase.invoke(l).awaitResponse()
                                    geoLocationRepository.updateGeoLocationSync(
                                        1,
                                        l.Id_geo_location!!
                                    )
                                }
                            }

                        }


                        /*LocationManager.stop(this)*/
                        /*GlobalScope.launch(Dispatchers.Main) {
                        withContext(Dispatchers.IO) {
                            withContext(Dispatchers.Main){
                                geoLocationRepository.insertGeoLocation(GeoLocationEntity(0, latitude, longitude, sharedPreferencesRepository.user, Date()))
                            }
                        }

                    }*/
                    } catch (e: Exception) {
                        System.out.println("Error Location Manager request" + e.message)
                    }
                }
        //you can also use location manager like this
        //because interval, priority has default value
        /*LocationManager.Builder.create(this).request {latitude, longitude ->
            val locationString = "${latitude}\n${longitude}"
            binding.tvLocation.text = locationString
        }*/
    }

}