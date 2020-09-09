package com.example.education.presentation.activity

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.education.R
import com.example.education.data.Subject
import com.example.education.presentation.adapter.StudentPagerAdapter
import com.example.education.presentation.fragments.*
import kotlinx.android.synthetic.main.fragment_students_pager.*

abstract class BaseActivity : AppCompatActivity() {
    var fragment = StudentsFragment()
    var addFragment = AddFragment()
    var noteFragment = NotesFragment()
    var addNoteFragment = AddNoteFragment()
    var studentPagerFragment = StudentsPagerFragment()
    var subjectFragment = SubjectsFragment()
    var currentFragment: Fragment? = null
    var isVisibleFragment: Boolean = false

    fun displayFragment(fragmentTemp: Fragment) {
        if(currentFragment != null) {
            if(isVisibleFragment) {
                supportFragmentManager
                    .beginTransaction()
                    .hide(addFragment)
                    .show(subjectFragment)
                    .commit()
            } else {
                supportFragmentManager
                    .beginTransaction()
                    .hide(subjectFragment)
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
            .add(R.id.frameLayout_activity_main_container, subjectFragment)
            .commit()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout_activity_main_container, addFragment)
            .hide(addFragment)
            .commit()
    }

    fun initializeStudentsFragment(s: Subject) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout_activity_main_container, fragment)
            .hide(subjectFragment)
            .commit()

        fragment.initializeFromSubject(s)
    }
}