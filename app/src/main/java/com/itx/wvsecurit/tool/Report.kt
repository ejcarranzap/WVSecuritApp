package com.itx.wvsecurit.tool

import android.app.Activity
import android.content.Context
import android.widget.Toast

class Report(var exc: Throwable) {
    companion object {
        lateinit var ctx: Context
        lateinit var mainActivity: Activity
    }
    public fun deliver(){
        mainActivity.runOnUiThread(java.lang.Runnable {
            Toast.makeText(ctx, exc.message, Toast.LENGTH_LONG).show()
        })
    }
}