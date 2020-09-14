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
    private var studentName: String = ""
    private var studentGroup: String = ""
    private var studentMark: Double = 0.0

    fun newInstance(s: Student): StudentsPagerFragment {
        val arguments = Bundle()
        arguments.putString(ARGUMENT_STUDENT_NAME, s.name)
        arguments.putString(ARGUMENT_STUDENT_GROUP, s.group)
        arguments.putDouble(ARGUMENT_STUDENT_MARK, s.avgMark)
        val pagerFragment: StudentsPagerFragment = StudentsPagerFragment()
        pagerFragment.arguments = arguments
        return pagerFragment
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_students_pager, container, false)
        return rootView
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            studentName = arguments!!.getString(ARGUMENT_STUDENT_NAME).toString()
            studentGroup = arguments!!.getString(ARGUMENT_STUDENT_GROUP).toString()
            studentMark = arguments!!.getDouble(ARGUMENT_STUDENT_MARK)
            textview_fragment_pager_name.text = studentName
            textview_fragment_pager_mark.text = studentMark.toString()
            textview_fragment_pager_age.text = "Age: 20"
            textview_fragment_pager_group.text = studentGroup
        }
    }

}