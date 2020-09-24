package com.practic.studentfragment.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.practic.studentfragment.R
import com.practic.studentfragment.domain.Student


class StudentDetailFragment : Fragment() {

    var rootView: View? = null
    var imgView: ImageView? = null
    var textView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = LayoutInflater.from(context)
            .inflate(R.layout.fragment_student_detail, container, false)
        imgView = rootView?.findViewById(R.id.imageview_detail_student_avatar)
        textView = rootView?.findViewById(R.id.textview_detail_student_name)
        val bundle: Bundle? = this.arguments
        val student: Student? = bundle?.getParcelable("studentFromStudentFragment")
        imgView?.setImageBitmap(student?.image)
        textView?.text = student?.name
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}