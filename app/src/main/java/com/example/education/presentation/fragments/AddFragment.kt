package com.example.education.presentation.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.education.R
import com.example.education.presentation.activity.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_add.*


class AddFragment : Fragment() {
    private var rootView : View? = null
    private var name: String = "null"
    private var surname: String = "null"
    private var mark: Double = 0.0
    private var group: String = "null"
    var currentFragment: Fragment? = null

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
                edittext_fragment_add_mark.text.isNotEmpty() && edittext_fragment_add_group.text.isNotEmpty()) {
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
        toActivity(name, surname, mark, group)

//        activity?.supportFragmentManager
//            ?.beginTransaction()
//            ?.remove(this)
//            ?.commit()
//        activity?.supportFragmentManager
//            ?.beginTransaction()
//            ?.show(StudentsFragment())
//            ?.commit()
    }

    fun toActivity(name: String, surname: String, mark: Double, group: String) {
        val activity: Activity? = activity
        if (activity != null && !activity.isFinishing && activity is MainActivity) {
            activity.fromFragmentData(name, surname, mark, group)
        }
    }
}