package com.example.education.presentation.activity

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.education.R
import com.example.education.presentation.adapter.StudentPagerAdapter
import com.example.education.presentation.fragments.*
import kotlinx.android.synthetic.main.fragment_students_pager.*

abstract class BaseActivity : AppCompatActivity() {
    val fragment = StudentsFragment()
    val addFragment = AddFragment()
    val noteFragment = NotesFragment()
    val addNoteFragment = AddNoteFragment()
    val studentPagerFragment = StudentsPagerFragment()
    var currentFragment: Fragment? = null
    var isVisibleFragment: Boolean = false

    fun displayFragment(fragmentTemp: Fragment) {
        if(currentFragment != null) {
            if(isVisibleFragment) {
                supportFragmentManager
                    .beginTransaction()
                    .hide(addFragment)
                    .show(fragment)
                    .commit()
            } else {
                supportFragmentManager
                    .beginTransaction()
                    .hide(fragment)
                    .show(addFragment)
                    .commit()
            }

            isVisibleFragment = !isVisibleFragment
        }
    }

    fun initializeDefaultFragment() {
        currentFragment = StudentsFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout_activity_main_container, fragment)
            .hide(fragment)
            .commit()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout_activity_main_container, studentPagerFragment)
            .commit()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout_activity_main_container, addFragment)
            .hide(addFragment)
            .commit()
    }
}