package com.itx.wvsecurit.tool

import android.app.AlertDialog
import android.content.Context
import android.view.WindowManager
import javax.inject.Inject

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