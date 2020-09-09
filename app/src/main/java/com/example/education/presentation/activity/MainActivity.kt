package com.example.education.presentation.activity

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.education.R
import com.example.education.presentation.adapter.StudentPagerAdapter
import com.example.education.presentation.fragments.NotesFragment
import com.example.education.presentation.fragments.StudentsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_item_subject.*
import kotlinx.android.synthetic.main.fragment_students_pager.*


class MainActivity : BaseActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeDefaultFragment()

        edittext_activity_main_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
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
            displayFragment(addFragment)
        }

        textview_activity_main_api_version.text = "v" + Build.VERSION.SDK_INT.toString()
    }

    fun fromFragmentData(name: String, surname: String, mark: Double, group: String) {
        displayFragment(fragment)
        fragment.addStudent(name, surname, mark, group)
        //noteFragment.addNote(title, description,  deadline)
    }
}