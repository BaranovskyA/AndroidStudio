package com.example.education.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.education.presentation.fragments.*

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

//    fun initializeDefaultFragment() {
//        currentFragment = StudentsFragment()
//
//        supportFragmentManager
//            .beginTransaction()
//            .add(R.id.frameLayout_activity_main_container, subjectFragment)
//            .commit()
//
//        supportFragmentManager
//            .beginTransaction()
//            .add(R.id.frameLayout_activity_main_container, addFragment)
//            .hide(addFragment)
//            .commit()
//    }
//
//    fun initializeStudentsFragment(s: Subject) {
//        supportFragmentManager
//            .beginTransaction()
//            .add(R.id.frameLayout_activity_main_container, fragment)
//            .hide(subjectFragment)
//            .commit()
//
//        fragment.initializeFromSubject(s)
//    }
}