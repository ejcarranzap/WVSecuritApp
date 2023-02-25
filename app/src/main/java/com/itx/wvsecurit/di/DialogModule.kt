package com.itx.wvsecurit.di

import android.app.AlertDialog
import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.itx.wvsecurit.R
import com.itx.wvsecurit.tool.MyCustomDialogFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject


@Module
@InstallIn(ActivityComponent::class)
class DialogModule @Inject constructor() {

    @Provides
    fun provideMyAlertDialog(@ActivityContext activity: Context) : AlertDialog {
        val builder = AlertDialog.Builder(activity)
        builder.setCancelable(false)
        builder.setView(R.layout.layout_loading_dialog)
        val dialog = builder.create()
        return dialog
    }

    @Provides
    fun provideMyCustomDialogFragment(@ActivityContext activity: Context): MyCustomDialogFragment {
        return MyCustomDialogFragment((activity as FragmentActivity).supportFragmentManager)
    }
}