package com.itx.wvsecurit.ui.view

import android.Manifest
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.itx.wvsecurit.R
import com.itx.wvsecurit.databinding.ActivityLoginBinding
import com.itx.wvsecurit.domain.usecase.GetLoginUseCase
import com.itx.wvsecurit.tool.ManagePermissions
import com.itx.wvsecurit.tool.MyDialog
import com.itx.wvsecurit.ui.viewmodel.LoadingViewModel
import com.itx.wvsecurit.ui.viewmodel.SharedPreferencesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import retrofit2.awaitResponse
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var managePermissions: ManagePermissions
    private val PermissionsRequestCode = 123

    @Inject lateinit var getLoginUseCase: GetLoginUseCase
    @Inject lateinit var myDialog: MyDialog

    private lateinit var binding: ActivityLoginBinding
    private val sharedPreferencesViewModel: SharedPreferencesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            managePermissions.checkPermissions()
        }

        Thread.setDefaultUncaughtExceptionHandler { thread, e ->
            GlobalScope.launch(Dispatchers.Main) {
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


        binding.btnLogin.setOnClickListener(View.OnClickListener {

            GlobalScope.launch(Dispatchers.Main) {
                withContext(Dispatchers.IO) {
                    //Do background tasks...
                    //delay(3000)
                    withContext(Dispatchers.Main){
                        //Update UI
                        myDialog.show()
                        login()
                        myDialog.dismiss()
                    }
                }

            }

        })
    }

    suspend fun login() {
        val user = binding.etUser.text.toString()
        val password = binding.etPassword.text.toString()

        val response = getLoginUseCase(user, Base64.getEncoder().encodeToString(password.toByteArray())).awaitResponse()

        if(response.body()!!.code == "0"){
            sharedPreferencesViewModel.setIsLogin(true)
            sharedPreferencesViewModel.setUser(response.body()!!.username!!)
            sharedPreferencesViewModel.setToken(response.body()!!.token!!)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(applicationContext, response.body()!!.msg, Toast.LENGTH_SHORT).show()
        }
    }
}