package com.example.education.presentation.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.education.data.Student
import com.example.education.presentation.fragments.StudentsPagerFragment

class StudentPagerAdapter(fragmentPager: FragmentManager, val students: ArrayList<Student>)
    : FragmentStatePagerAdapter(fragmentPager) {
    override fun getItem(position: Int): Fragment {
        return StudentsPagerFragment().newInstance(students[position])
    }

    override fun getCount(): Int {
        return students.size
    }
}