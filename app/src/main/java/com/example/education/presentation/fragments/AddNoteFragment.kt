package com.example.education.presentation.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.education.R
import com.example.education.presentation.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_add_note.*
import java.time.LocalDate

class AddNoteFragment : BaseFragment() {
    private var title: String = "null"
    private var description: String = "null"
    @RequiresApi(Build.VERSION_CODES.O)
    private var deadline: LocalDate = LocalDate.now()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_add_note, container, false)
        return rootView
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_fragment_add_note.setOnClickListener {
            initializeData()
            if(textview_fragment_add_note_error.text == "") {
                addStudent()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    override fun initializeData() {
        if(edittext_fragment_add_note_title.text.isNotEmpty() && edittext_fragment_add_note_description.text.isNotEmpty() &&
            edittext_fragment_add_note_deadline.text.isNotEmpty()) {
            title = edittext_fragment_add_note_title.text.toString()
            description = edittext_fragment_add_note_description.text.toString()
            val arrayDate = edittext_fragment_add_note_deadline.text.split('.', '-')
            deadline = LocalDate.of(arrayDate[2].toInt(), arrayDate[1].toInt(), arrayDate[0].toInt())
            textview_fragment_add_note_error.text = ""
        } else {
            textview_fragment_add_note_error.text = "You missed one of the parameters!"
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addStudent() {
        //toActivity(title, description, deadline)
    }

//    fun toActivity(title: String, description: String, deadline: LocalDate) {
//        val activity: Activity? = activity
//        if (activity != null && !activity.isFinishing && activity is MainActivity) {
//            activity.fromFragmentData(title, description, deadline)
//        }
//    }
}