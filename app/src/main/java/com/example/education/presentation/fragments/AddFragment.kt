package com.example.education.presentation.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.education.R
import com.example.education.presentation.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_add.*
import java.util.*


class AddFragment : BaseFragment() {
    private var name: String = "null"
    private var surname: String = "null"
    private var mark: Double = 0.0
    private var birthdate: String = "null"
    private var group: String = "null"

    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_add, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_fragment_add_birthdate.setOnClickListener {
            val dpd =
                activity?.let {
                    DatePickerDialog(it, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        birthdate = "$dayOfMonth.$monthOfYear.$year"
                        textview_fragment_add_birthdate.text = "Birthdate: $birthdate"
                    }, year, month, day)
                }

            dpd!!.show()
        }

        button_fragment_add.setOnClickListener {
            initializeData()
            if(textview_fragment_add_error.text == "") {
                addStudent()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun initializeData() {
        if(edittext_fragment_add_name.text.isNotEmpty() && edittext_fragment_add_surname.text.isNotEmpty() &&
                edittext_fragment_add_mark.text.isNotEmpty() && edittext_fragment_add_group.text.isNotEmpty()
                && birthdate != "null") {
            name = edittext_fragment_add_name.text.toString()
            surname = edittext_fragment_add_surname.text.toString()
            mark = edittext_fragment_add_mark.text.toString().toDouble()
            group = edittext_fragment_add_group.text.toString()
            textview_fragment_add_error.text = ""
        } else {
            textview_fragment_add_error.text = "You missed one of the parameters!"
        }
    }

    fun addStudent() {
        toActivity(name, surname, mark, group, birthdate)
    }

    fun toActivity(name: String, surname: String, mark: Double, group: String, birthdate: String) {
        val activity: Activity? = activity
        if (activity != null && !activity.isFinishing && activity is MainActivity) {
            activity.fromFragmentStudentData(name, surname, mark, group, birthdate)
        }
    }
}