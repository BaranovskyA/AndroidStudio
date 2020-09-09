package com.example.education.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.education.R
import com.example.education.data.Student
import kotlinx.android.synthetic.main.fragment_students_pager.*


class StudentsPagerFragment () : BaseFragment() {
    val ARGUMENT_STUDENT_NAME = "arg_student_name"
    val ARGUMENT_STUDENT_GROUP = "arg_student_group"
    val ARGUMENT_STUDENT_MARK = "arg_student_mark"
    var student: Student? = null

    fun newInstance(s: Student): AddFragment {
        val pagerFragment = StudentsPagerFragment()
        val arguments = Bundle()
        student = s
        arguments.putString(ARGUMENT_STUDENT_NAME, s.name)
        arguments.putString(ARGUMENT_STUDENT_GROUP, s.group)
        arguments.putDouble(ARGUMENT_STUDENT_MARK, s.avgMark)
        pagerFragment.arguments = arguments
        return AddFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_students_pager, null)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textview_fragment_pager_name?.text = student?.name
        textview_fragment_pager_mark?.text = student?.avgMark.toString()
        textview_fragment_pager_age?.text = student?.age.toString()
        textview_fragment_pager_group?.text = student?.group
    }

}