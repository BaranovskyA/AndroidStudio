package com.example.education.presentation.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.education.R
import com.example.education.presentation.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add_note.*
import java.time.LocalDate
import java.util.*

class AddNoteFragment : BaseFragment() {
    private var title: String = "null"
    private var description: String = "null"
    @RequiresApi(Build.VERSION_CODES.O)
    private var deadline: String = "null"

    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_add_note, container, false)
        return rootView
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_fragment_add_note_deadline.setOnClickListener {
            val dpd =
                activity?.let {
                    DatePickerDialog(it, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        val currentMonth = monthOfYear + 1
                        deadline = "$dayOfMonth.$currentMonth.$year"
                        textview_fragment_add_note_deadline.text = "Deadline: $deadline"
                    }, year, month, day)
                }

            dpd!!.show()
        }

        button_fragment_add_note.setOnClickListener {
            initializeData()
            if(textview_fragment_add_note_error.text == "") {
                addNote()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    fun initializeData() {
        if(edittext_fragment_add_note_title.text.isNotEmpty() && edittext_fragment_add_note_description.text.isNotEmpty() &&
            deadline != "null") {
            title = edittext_fragment_add_note_title.text.toString()
            description = edittext_fragment_add_note_description.text.toString()
            textview_fragment_add_note_error.text = ""
        } else {
            textview_fragment_add_note_error.text = "You missed one of the parameters!"
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addNote() {
        toActivity(title, description, deadline)
    }

    fun toActivity(title: String, description: String, deadline: String) {
        val activity: Activity? = activity
        if (activity != null && !activity.isFinishing && activity is MainActivity) {
            activity.fromFragmentNoteData(title, description, deadline)
        }
    }
}