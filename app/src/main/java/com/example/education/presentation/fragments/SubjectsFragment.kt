package com.example.education.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.education.R
import com.example.education.data.Student
import com.example.education.data.Subject
import com.example.education.presentation.activity.MainActivity
import com.example.education.presentation.adapter.SubjectAdapter
import kotlinx.android.synthetic.main.fragment_subjects.*

class SubjectsFragment : BaseFragment() {
    private var students: ArrayList<Student> = ArrayList()
    var subjects: ArrayList<Subject> = ArrayList()
    var adapter : SubjectAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_subjects, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeData()
        initializeAdapter()
        initializeRecyclerView()
        initializeLayoutManager()
    }

    fun updateAdapter() {
        adapter!!.notifyDataSetChanged()
    }

    fun initializeAdapter(){
        adapter = SubjectAdapter(subjects, activity as MainActivity)
    }

    fun initializeData() {
        students.add(
            Student()
                .apply { name = "Max Brown"; avatar =
                    R.drawable.student_icon; group = "SEP-171"; avgMark = 11.2 } )
        students.add(
            Student()
                .apply { name = "Cassie Gray"; avatar =
                    R.drawable.student_icon; group = "SEP-161"; avgMark = 8.2 } )
        students.add(
            Student()
                .apply { name = "John Green"; avatar =
                    R.drawable.student_icon; group = "SEP-191"; avgMark = 10.2 })
        students.add(
            Student()
                .apply { name = "Darvin Yellow"; avatar =
                    R.drawable.student_icon; group = "SEP-181"; avgMark = 12.0 })
        students.add(
            Student()
                .apply { name = "Bob Purple"; avatar =
                    R.drawable.student_icon; group = "SEP-161"; avgMark = 11.1 })
        students.add(
            Student()
                .apply { name = "Mike White"; avatar =
                    R.drawable.student_icon; group = "SEP-191"; avgMark = 11.6 })
        students.add(
            Student()
                .apply { name = "Mitchell Red"; avatar =
                    R.drawable.student_icon; group = "SEP-191"; avgMark = 9.8 })
        students.add(
            Student()
                .apply { name = "Ariana Blue"; avatar =
                    R.drawable.student_icon; group = "SEP-181"; avgMark = 10.4 })
        students.add(
            Student()
                .apply { name = "Michael Stone"; avatar =
                    R.drawable.student_icon; group = "SEP-171"; avgMark = 9.1 })
        students.add(
            Student()
                .apply { name = "Armando Tree"; avatar =
                    R.drawable.student_icon; group = "SEP-191"; avgMark = 8.5 })
        val s1: ArrayList<Student> = ArrayList()
        s1.add(Student().apply { name = "Test Student 1"; avatar =
            R.drawable.student_icon; group = "SEP-1000"; avgMark = 12.0 })

        val s2: ArrayList<Student> = ArrayList()
        s2.add(Student().apply { name = "Test Student 2"; avatar =
            R.drawable.student_icon; group = "SEP-2000"; avgMark = 15.0 })

        s1.addAll(s2)

        subjects.add(Subject().apply { title = "Class 1"; pupils = students })
        subjects.add(Subject().apply { title = "Class 2"; pupils = s1 })
        subjects.add(Subject().apply { title = "Class 3"; pupils = s2 })
    }

    private fun initializeLayoutManager(){
        recyclerview_fragment_subjects?.layoutManager = LinearLayoutManager(context)
    }

    private fun initializeRecyclerView(){
        recyclerview_fragment_subjects?.adapter = adapter
    }
}