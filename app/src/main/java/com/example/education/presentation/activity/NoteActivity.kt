package com.example.education.presentation.activity

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.education.R
import com.example.education.presentation.fragments.StudentsFragment


class NoteActivity : BaseActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        initializeDefaultFragment()
//
//        fab_fragment_students.setOnClickListener {
//            displayFragment(addFragment)
//        }
//
//        textview_activity_main_api_version.text = "v" + Build.VERSION.SDK_INT.toString()
    }

    fun fromFragmentData(name: String, surname: String, mark: Double, group: String, birthdate: String) {
        displayFragment(StudentsFragment())
        fragment.addStudent(name, surname, mark, group, birthdate)
    }
}