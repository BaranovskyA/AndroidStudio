package com.example.education.presentation.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class StudentPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val fragmentList : MutableList<Fragment> = ArrayList()
    private val nameFragment : MutableList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun addFragment(fragment: Fragment,name : String){
        fragmentList.add(fragment)
        nameFragment.add(name)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return nameFragment[position]
    }
}