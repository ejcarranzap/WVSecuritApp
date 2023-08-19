package com.itx.wvsecurit.tool

import android.app.AlertDialog
import javax.inject.Inject
import javax.inject.Singleton

class MyDialog  @Inject constructor(private val alertDialog: AlertDialog) {
    fun show(){
        alertDialog.show()
    }
    fun dismiss(){
        alertDialog.dismiss()
    }

    fun setTitle(title: String){
        alertDialog.setTitle(title)
    }
}