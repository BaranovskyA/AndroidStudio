package com.example.education.presentation.activity

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.education.R
import com.example.education.presentation.fragments.AddFragment
import com.example.education.presentation.fragments.StudentsFragment

abstract class BaseActivity : AppCompatActivity() {
    val fragment = StudentsFragment()
    val addFragment = AddFragment()
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
            .commit()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout_activity_main_container, addFragment)
            .hide(addFragment)
            .commit()
    }
}