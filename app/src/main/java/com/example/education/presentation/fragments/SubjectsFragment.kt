package com.example.education.presentation.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.education.R
import com.example.education.data.Student
import com.example.education.data.Subject
import com.example.education.presentation.activity.MainActivity
import com.example.education.presentation.adapter.SubjectAdapter
import kotlinx.android.synthetic.main.fragment_students.*
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
                .apply { name = "Max Brown"; age = 19; avatar =
                    R.drawable.student_icon; group = "SEP-171"; avgMark = 11.2 } )
        students.add(
            Student()
                .apply { name = "Cassie Gray"; age = 18; avatar =
                    R.drawable.student_icon; group = "SEP-161"; avgMark = 8.2 } )
        students.add(
            Student()
                .apply { name = "John Green"; age = 21; avatar =
                    R.drawable.student_icon; group = "SEP-191"; avgMark = 10.2 })
        students.add(
            Student()
                .apply { name = "Darvin Yellow"; age = 20; avatar =
                    R.drawable.student_icon; group = "SEP-181"; avgMark = 12.0 })
        students.add(
            Student()
                .apply { name = "Bob Purple"; age = 18; avatar =
                    R.drawable.student_icon; group = "SEP-161"; avgMark = 11.1 })
        students.add(
            Student()
                .apply { name = "Mike White"; age = 21; avatar =
                    R.drawable.student_icon; group = "SEP-191"; avgMark = 11.6 })
        students.add(
            Student()
                .apply { name = "Mitchell Red"; age = 21; avatar =
                    R.drawable.student_icon; group = "SEP-191"; avgMark = 9.8 })
        students.add(
            Student()
                .apply { name = "Ariana Blue"; age = 20; avatar =
                    R.drawable.student_icon; group = "SEP-181"; avgMark = 10.4 })
        students.add(
            Student()
                .apply { name = "Michael Stone"; age = 19; avatar =
                    R.drawable.student_icon; group = "SEP-171"; avgMark = 9.1 })
        students.add(
            Student()
                .apply { name = "Armando Tree"; age = 21; avatar =
                    R.drawable.student_icon; group = "SEP-191"; avgMark = 8.5 })
        val s1: ArrayList<Student> = ArrayList()
        s1.add(Student().apply { name = "Test Student 1"; age = 25; avatar =
            R.drawable.student_icon; group = "SEP-1000"; avgMark = 12.0 })

        val s2: ArrayList<Student> = ArrayList()
        s2.add(Student().apply { name = "Test Student 2"; age = 25; avatar =
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