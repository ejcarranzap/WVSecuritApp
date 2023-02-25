package com.itx.wvsecurit.tool

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.itx.wvsecurit.R
import javax.inject.Inject

class MyCustomDialogFragment @Inject constructor(private val supportFragmentManager: FragmentManager): DialogFragment() {
    private lateinit var mainView: View
    private var title: String = ""
    private var msg: String = ""
    private var hintText:String = "Value"
    private var okText: String = "OK"
    private var cancelText: String = "CANCEL"
    private var showValue: Boolean = false

    lateinit var function: (view: View) -> Unit

    fun showDialog(){
        this.show(supportFragmentManager,"")
    }

    fun dismissDialog(){
        var et = mainView.findViewById<EditText>(R.id.etValue)
        et.setText("")
        this.dismiss()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*return super.onCreateView(inflater, container, savedInstanceState)*/
        this.mainView = inflater.inflate(R.layout.dialog_custom, container, false)
        var me = this

        var tv = mainView.findViewById<TextView>(R.id.tvTitle)
        tv.text = me.title

        tv = mainView.findViewById<TextView>(R.id.tvMessage)
        tv.text = me.msg

        var btn = this.mainView.findViewById<Button>(R.id.btnOk)
        btn.text = me.okText

        btn = this.mainView.findViewById<Button>(R.id.btnCancel)
        btn.text = me.cancelText

        var et = mainView.findViewById<EditText>(R.id.etValue)
        et.setText("")
        et.hint = this.hintText

        if(!this.showValue){
            et.visibility = View.GONE
        }else{
            et.visibility = View.VISIBLE
        }

        mainView.findViewById<Button>(R.id.btnCancel).setOnClickListener(View.OnClickListener {
            me.dismiss()
        })

        mainView.findViewById<Button>(R.id.btnOk).setOnClickListener(View.OnClickListener {
            me.function(mainView)
            me.dismiss()
        })

        return mainView
    }

    override fun onStart() {
        super.onStart()

        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun setTitleDialog(title: String){
        this.title = title
    }

    fun setMsgDialog(msg: String){
        this.msg = msg
    }

    fun setFunctionDialog(function: (view: View) -> Unit){
        this.function = function
    }

    fun setOkBtnText(text: String){
        this.okText = text
    }

    fun setCancelBtnText(text: String){
        this.cancelText = text
    }
    fun setShowValueField(show: Boolean){
        this.showValue = show
    }
}