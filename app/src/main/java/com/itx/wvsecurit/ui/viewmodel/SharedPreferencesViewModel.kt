package com.itx.wvsecurit.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itx.wvsecurit.data.preferences.SharedPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedPreferencesViewModel @Inject constructor(private val sharedPreferencesRepository: SharedPreferencesRepository) : ViewModel(){
    var isGpsTracking = MutableLiveData<Boolean>()
    var isLogin = MutableLiveData<Boolean>()
    var token = MutableLiveData<String>()
    var user = MutableLiveData<String>()

    fun setIsGpsTracking(value: Boolean){
        sharedPreferencesRepository.gpsTracking = value
        isGpsTracking.postValue(value)
    }

    fun setIsLogin(value: Boolean){
        sharedPreferencesRepository.isLogin = value
        isLogin.postValue(value)
    }

    fun setToken(value: String){
        sharedPreferencesRepository.token = value
        token.postValue(value)
    }

    fun setUser(value: String){
        sharedPreferencesRepository.user = value
        user.postValue(value)
    }

    fun onCreate(){
        //isGpsTracking.postValue(sharedPreferencesRepository.gpsTracking)
        isLogin.postValue(sharedPreferencesRepository.isLogin)
        token.postValue(sharedPreferencesRepository.token)
        user.postValue(sharedPreferencesRepository.user)
    }
}