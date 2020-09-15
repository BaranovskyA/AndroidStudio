package com.example.education.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


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