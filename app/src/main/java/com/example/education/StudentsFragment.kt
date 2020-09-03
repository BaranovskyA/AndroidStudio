package com.example.education

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_students.*

class StudentsFragment : Fragment() {

    var students: ArrayList<Student> = ArrayList()
    var adapter : StudentAdapter? = null
    private var rootView : View? = null
    var COUNT_BEST_STUDENTS = 6

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_students, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeAdapter()
        initializeData()
        initializeRecyclerView()
        initializeLayoutManager()

        sortArrayByMarks()
    }

    fun initializeAdapter(){
        adapter = StudentAdapter(students)
    }

    fun selector(s: Student): Double = s.avgMark

    private fun sortArrayByMarks() {
        var counter = 0
        var newStudents: ArrayList<Student> = ArrayList()

        students.sortByDescending {selector(it)}
        students.forEach {
            if(counter < COUNT_BEST_STUDENTS) {
                newStudents.add(it)
                counter++
            }
        }
        students = newStudents

        initializeAdapter()
        initializeRecyclerView()
        initializeLayoutManager()
    }

    private fun initializeData(){
        students.add(Student().apply { name = "Max Brown"; age = 19; avatar = R.drawable.student_icon; group = "SEP-171"; avgMark = 11.2 } )
        students.add(Student().apply { name = "Cassie Gray"; age = 18; avatar = R.drawable.student_icon; group = "SEP-161"; avgMark = 8.2 } )
        students.add(Student().apply { name = "John Green"; age = 21; avatar = R.drawable.student_icon; group = "SEP-191"; avgMark = 10.2 })
        students.add(Student().apply { name = "Darvin Yellow"; age = 20; avatar = R.drawable.student_icon; group = "SEP-181"; avgMark = 12.0 })
        students.add(Student().apply { name = "Bob Purple"; age = 18; avatar = R.drawable.student_icon; group = "SEP-161"; avgMark = 11.1 })
        students.add(Student().apply { name = "Mike White"; age = 21; avatar = R.drawable.student_icon; group = "SEP-191"; avgMark = 11.6 })
        students.add(Student().apply { name = "Mitchell Red"; age = 21; avatar = R.drawable.student_icon; group = "SEP-191"; avgMark = 9.8 })
        students.add(Student().apply { name = "Ariana Blue"; age = 20; avatar = R.drawable.student_icon; group = "SEP-181"; avgMark = 10.4 })
        students.add(Student().apply { name = "Michael Stone"; age = 19; avatar = R.drawable.student_icon; group = "SEP-171"; avgMark = 9.1 })
        students.add(Student().apply { name = "Armando Tree"; age = 21; avatar = R.drawable.student_icon; group = "SEP-191"; avgMark = 8.5 })
    }

    private fun initializeLayoutManager(){
        recyclerview_fragment_students?.layoutManager = LinearLayoutManager(context)
        recyclerview_fragment_students?.adapter = StudentAdapter(students)
    }

    private fun initializeRecyclerView(){
        recyclerview_fragment_students?.adapter = adapter
    }
}