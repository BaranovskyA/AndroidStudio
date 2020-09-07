package com.example.education.presentation.activity

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import com.example.education.R
import com.example.education.presentation.fragments.AddFragment
import com.example.education.presentation.fragments.StudentsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_students.*


class MainActivity : AppCompatActivity() {
    val fragment = StudentsFragment()
    val addFragment = AddFragment()
    var currentFragment: Fragment? = null
    var isVisibleFragment: Boolean = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayFragment(StudentsFragment())

        edittext_activity_main_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.isNullOrEmpty())
                    fragment.searchForName("")
                else
                    fragment.searchForName(edittext_activity_main_search.text.toString())
            }
        })

        button_activity_main_sort_name.setOnClickListener {
            fragment.sortStudentsByName()
        }

        button_activity_main_sort_mark.setOnClickListener {
            fragment.sortStudentsByMark()
        }

        button_activity_main_sort_random.setOnClickListener {
            fragment.sortStudentsByRandom()
        }

        fab_fragment_students.setOnClickListener {
            displayFragment(AddFragment())
        }

        textview_activity_main_api_version.text = "v" + Build.VERSION.SDK_INT.toString()
    }

    private fun displayFragment(fragmentTemp: Fragment) {
        if(currentFragment == null) {
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
        } else {
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

    fun fromFragmentData(name: String, surname: String, mark: Double, group: String) {
        displayFragment(StudentsFragment())
        fragment.addStudent(name, surname, mark, group)
    }
}