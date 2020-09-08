package com.example.education.presentation.activity

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.education.R
import com.example.education.presentation.fragments.AddFragment
import com.example.education.presentation.fragments.AddNoteFragment
import com.example.education.presentation.fragments.NotesFragment
import com.example.education.presentation.fragments.StudentsFragment

abstract class BaseActivity : AppCompatActivity() {
    val fragment = StudentsFragment()
    val addFragment = AddFragment()
    val noteFragment = NotesFragment()
    val addNoteFragment = AddNoteFragment()
    var currentFragment: Fragment? = null
    var isVisibleFragment: Boolean = false

    fun displayFragment(fragmentTemp: Fragment) {
        if(currentFragment != null) {
            if(isVisibleFragment) {
                supportFragmentManager
                    .beginTransaction()
                    .hide(addNoteFragment)
                    .show(noteFragment)
                    .commit()
            } else {
                supportFragmentManager
                    .beginTransaction()
                    .hide(noteFragment)
                    .show(addNoteFragment)
                    .commit()
            }

            isVisibleFragment = !isVisibleFragment
        }
    }

    fun initializeDefaultFragment() {
        currentFragment = StudentsFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout_activity_main_container, noteFragment)
            .commit()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout_activity_main_container, addNoteFragment)
            .hide(addNoteFragment)
            .commit()
    }
}