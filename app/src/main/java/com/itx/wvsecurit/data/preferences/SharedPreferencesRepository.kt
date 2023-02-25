package com.itx.wvsecurit.data.preferences

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class SharedPreferencesRepository @Inject constructor(private val sharedPreferences: SharedPreferences, private val editor: Editor){

    companion object {
        const val sharedToken = "shared_token"
        const val sharedUser = "shared_user"
        const val sharedIsLogin = "shared_is_login"
        const val sharedIsGpsTraking = "sharedIsGpsTraking"
    }

    var isLogin: Boolean
        get() = sharedPreferences.getBoolean(sharedIsLogin, false)
        set(value) = editor.putBoolean(sharedIsLogin, value).apply()

    var gpsTracking: Boolean
        get() = sharedPreferences.getBoolean(sharedIsGpsTraking, false)
        set(value) = editor.putBoolean(sharedIsGpsTraking, value).apply()

    var token: String
        get() = sharedPreferences.getString(sharedToken, "").toString()
        set(value) = editor.putString(sharedToken, value).apply()

    var user: String
        get() = sharedPreferences.getString(sharedUser, "").toString()
        set(value) = editor.putString(sharedUser, value).apply()

    fun clearPreferences(){
        editor.clear()
        editor.commit()
    }
}