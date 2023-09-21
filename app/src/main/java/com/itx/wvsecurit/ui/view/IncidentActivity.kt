package com.itx.wvsecurit.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.internal.ViewUtils.hideKeyboard
import com.itx.common.jcdata.CustomResponse
import com.itx.wvsecurit.R
import com.itx.wvsecurit.data.database.SegIncidentRepository
import com.itx.wvsecurit.data.database.SegIncidentTypeRepository
import com.itx.wvsecurit.data.database.entities.FileEntity
import com.itx.wvsecurit.data.database.entities.SegIncidentEntity
import com.itx.wvsecurit.data.database.entities.SegIncidentTypeEntity
import com.itx.wvsecurit.data.database.entities.SendMailEntity
import com.itx.wvsecurit.data.network.SegIncidentApiClient
import com.itx.wvsecurit.data.network.SendMailService
import com.itx.wvsecurit.data.network.UploadService
import com.itx.wvsecurit.data.preferences.SharedPreferencesRepository
import com.itx.wvsecurit.databinding.ActivityIncidentBinding
import com.itx.wvsecurit.domain.usecase.AddGeoLocationUseCase
import com.itx.wvsecurit.domain.usecase.AddSegIncidentUseCase
import com.itx.wvsecurit.domain.usecase.GetSegIncidentTypeUseCase
import com.itx.wvsecurit.tool.MyDialog
import com.itx.wvsecurit.tool.MyImageTool
import com.itx.wvsecurit.tool.Report
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse
import java.io.File
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.schedule


@AndroidEntryPoint
class IncidentActivity : AppCompatActivity()  {
    val REQUEST_IMAGE_CAPTURE = 1
    val CAPTURE_IMAGE_FULLSIZE_ACTIVITY_REQUEST_CODE = 1777

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    @Inject lateinit var sendMailService: SendMailService
    @Inject lateinit var segIncidentTypeRepository: SegIncidentTypeRepository
    @Inject lateinit var segIncidentTypeUseCase: GetSegIncidentTypeUseCase
    @Inject lateinit var sharedPreferencesRepository: SharedPreferencesRepository
    @Inject lateinit var segIncidentRepository: SegIncidentRepository
    @Inject lateinit var myDialog: MyDialog
    @Inject lateinit var uploadService: UploadService

    @Inject lateinit var addIncidentUseCase: AddSegIncidentUseCase


    private lateinit var binding: ActivityIncidentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        Thread.setDefaultUncaughtExceptionHandler { thread, e ->
            myDialog.dismiss()
            GlobalScope.launch(Dispatchers.Main) {
                withContext(Dispatchers.Main){
                    Toast.makeText(applicationContext,"Error Incident: " + e.message, Toast.LENGTH_LONG).show()
                }
            }


            finish()

            /*handleUncaughtException(
                thread,
                e
            )*/
        }

        MyImageTool.context = applicationContext
        binding = ActivityIncidentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivImage.setOnClickListener {
            dispatchTakePictureIntent2()
        }

        binding.btnSave.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                withContext(Dispatchers.IO) {
                    //Do background tasks...
                    //delay(3000)
                    withContext(Dispatchers.Main){
                        myDialog.show()
                        save()
                        myDialog.dismiss()
                        finish()
                    }
                }

            }
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }

        val inputMethodManager =
            getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        // on below line hiding our keyboard.
        inputMethodManager.hideSoftInputFromWindow(binding.root.windowToken, 0)

        getAddIncident()
    }

    @SuppressLint("MissingPermission")
    private suspend fun save(){
        addIncidentUseCase.invoke(SegIncidentEntity(0, "I",null, selectedItemObj.Id_incident_type,binding.etDescription.text.toString(), imgName,sharedPreferencesRepository.user, Date(),1,0)).awaitResponse()
        //segIncidentRepository.insert(SegIncidentEntity("", selectedItemObj.seg_incident_type_id,"0","0","Y", Date(), "", Date(),"", binding.etDescription.text.toString(), imgName,0))

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location : Location? ->
                lifecycleScope.launch(Dispatchers.Main) {
                    withContext(Dispatchers.IO) {
                        withContext(Dispatchers.Main){
                            sendMailService.post(
                                SendMailEntity("", "carlos_ordonez@wvi.org",
                                    "SEGURIDAD COORPORATIVA (INCIDENTE)","", "<h1>El usuario "+sharedPreferencesRepository.user+
                                            ",</h1><h3>Ha registrado un incidente (WSSecuritApp)</h3>" +
                                            "<a href=\"http://www.google.com/maps/place/"+location?.latitude+","+location?.longitude+"\">Ver Ubicacion</a>"
                                )
                            ).awaitResponse()
                        }
                    }
                }
            }

    }

    lateinit var selectedItemObj: SegIncidentTypeEntity
    private fun getAddIncident(){
        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                withContext(Dispatchers.Main){
                    myDialog.show()
                    segIncidentTypeRepository.deleteAll()
                    val res = segIncidentTypeUseCase.invoke().awaitResponse()
                    for (l in res.body()!!.data){
                        System.out.println("value: ${l.code} name: ${l.name}")
                        segIncidentTypeRepository.insert(l)
                    }

                    var incidents = segIncidentTypeRepository.getAll()
                    var adapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, incidents)
                    binding.sAddIncident.adapter = adapter
                    binding.sAddIncident.onItemSelectedListener = object: OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            selectedItemObj = parent!!.getItemAtPosition(position) as SegIncidentTypeEntity
                            var selectedItem = selectedItemObj.toString()
                            if(selectedItem == "Add new category"){

                            }
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {
                        }

                    }
                    myDialog.dismiss()
                }
            }

        }
    }

    private fun dispatchTakePictureIntent2(){
        val chooserIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        chooserIntent.putExtra(MediaStore.EXTRA_OUTPUT, setImageUri())
        startActivityForResult(chooserIntent, CAPTURE_IMAGE_FULLSIZE_ACTIVITY_REQUEST_CODE)
        //startActivityForResult(chooserIntent, REQUEST_IMAGE_CAPTURE)
    }

    lateinit var imgName: String
    lateinit var imgPath: String
    fun setImageUri(): Uri? {
        // Store image in dcim
        val file = File(
            Environment.getExternalStorageDirectory().toString() + "/DCIM/",
            "image.jpg"
        )
        val imgUri = Uri.fromFile(file)
        this.imgPath = file.absolutePath
        return imgUri
    }


    fun getImagePath(): String? {
        return imgPath
    }

    lateinit var outputFileUri: Uri
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 0 && resultCode == RESULT_OK) {
            outputFileUri = Uri.parse(data?.dataString);
            dispatchTakePictureIntent2()
        }

        if (requestCode == CAPTURE_IMAGE_FULLSIZE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            var imageBitmap: Bitmap =
                MyImageTool.decodeSampledBitmapFromFile(getImagePath(), 1600, 720)!!

            val iv: ImageView = findViewById(R.id.ivImage)
            iv.setImageBitmap(imageBitmap)
            iv.scaleType = ImageView.ScaleType.FIT_XY
            callUploadImageService(imageBitmap, UUID.randomUUID().toString() + ".png")
            //binding.ivImage.setImageBitmap(imageBitmap)
        }

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            var imageBitmap: Bitmap
            if (data?.data == null) {
                imageBitmap = data?.extras?.get("data") as Bitmap
            } else {
                /*imageBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, data.data)*/
                imageBitmap = data.data as Bitmap
            }

            val iv: ImageView = findViewById(R.id.ivImage)
            iv.setImageBitmap(imageBitmap)
            iv.scaleType = ImageView.ScaleType.FIT_XY
            callUploadImageService(imageBitmap, UUID.randomUUID().toString() + ".png")
            //binding.ivImage.setImageBitmap(imageBitmap)
        }
    }

    private fun createPartFromString(descriptionString: String): RequestBody {
        return RequestBody.create(
            okhttp3.MultipartBody.FORM, descriptionString)
    }

    private fun callUploadImageService(file: Bitmap, fileName: String) {
        val image1Part = MyImageTool.buildImageBodyPart(fileName, file)
        createPartFromString("test")

        var api = uploadService.uploadImages(file = image1Part)

        myDialog.show()
        api.enqueue(object : Callback<CustomResponse<FileEntity>> {
            override fun onResponse(call: Call<CustomResponse<FileEntity>>, response: Response<CustomResponse<FileEntity>>) {
                System.out.println("callUpload print: " + response.body().toString())
                myDialog.dismiss()
                if(response.code() != 200){
                    Report(Throwable(response.message())).deliver()
                }else{
                    imgName = response.body()!!.data.filename
                }
            }

            override fun onFailure(call: Call<CustomResponse<FileEntity>>, t: Throwable) {

            }

        })
    }
}