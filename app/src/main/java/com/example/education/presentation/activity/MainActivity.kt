package com.example.education.presentation.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.View
import com.example.education.R
import com.example.education.presentation.adapter.StudentPagerAdapter
import com.example.education.presentation.fragments.AddFragment
import com.example.education.presentation.fragments.AddNoteFragment
import com.example.education.presentation.fragments.NotesFragment
import com.example.education.presentation.fragments.StudentsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_students.*
import java.time.LocalDate


class MainActivity : BaseActivity() {
    val adapter = StudentPagerAdapter(supportFragmentManager)

    @SuppressLint("SetTextI18n", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializeDefaultFragment()


        viewpager_activity_main_container.setPadding(0,220,0,0)

        adapter.addFragment(fragment, "Students")
        adapter.addFragment(noteFragment, "Notes")

        adapter.addFragment(addFragment, "Add Student")
        adapter.addFragment(addNoteFragment, "Add Note")

        viewpager_activity_main_container.adapter = adapter
        tablayout_activity_main.setupWithViewPager(viewpager_activity_main_container)


//        edittext_activity_main_search.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {}
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                if(s.isNullOrEmpty())
//                    fragment.searchForName("")
//                else
//                    fragment.searchForName(edittext_activity_main_search.text.toString())
//            }
//        })
//
//        button_activity_main_sort_name.setOnClickListener {
//            fragment.sortStudentsByName()
//        }
//
//        button_activity_main_sort_mark.setOnClickListener {
//            fragment.sortStudentsByMark()
//        }
//
//        button_activity_main_sort_random.setOnClickListener {
//            fragment.sortStudentsByRandom()
//        }
//
//        fab_fragment_students.setOnClickListener {
//            displayFragment(addFragment)
//        }
//
//        textview_activity_main_api_version.text = "v" + Build.VERSION.SDK_INT.toString()
    }

    fun fromFragmentStudentData(name: String, surname: String, mark: Double, group: String, birthdate: String) {
        //displayFragment(fragment)
        fragment.addStudent(name, surname, mark, group, birthdate)
        adapter.notifyDataSetChanged()
    }

    fun fromFragmentNoteData(title: String, description: String, deadline: String) {
        displayFragment(noteFragment)
        noteFragment.addNote(title, description,  deadline)
    }
}