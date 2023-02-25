package com.itx.wvsecurit.tool

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.lang.ref.WeakReference

class AdapterTabPager(activity: FragmentActivity?) : FragmentStateAdapter(activity!!) {
    private val mFragmentList: ArrayList<Fragment> = ArrayList()
    private val mFragmentTitleList: ArrayList<String> = ArrayList()

    fun getTabTitle(position : Int): String{
        return mFragmentTitleList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getItemCount(): Int {
        return mFragmentList.size
    }

    fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun createFragment(position: Int): Fragment {
        return mFragmentList[position]
    }
}