package com.itx.wvsecurit.tool

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.itx.wvsecurit.R

class NewsFragment constructor(val viewChild: View): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainView = inflater.inflate(R.layout.layout_news_fragment, container, false)
        val fragment = mainView.rootView as ConstraintLayout
        //fragment.removeView(viewChild)
        (viewChild.parent as? ViewGroup)?.removeView(viewChild)
        fragment.addView(viewChild)

        return mainView
    }

    override fun onResume() {
        if(viewChild.javaClass.name.contains("VideoView")){
            val vc = viewChild as VideoView
            vc.start()
        }

        super.onResume()
    }
}