package com.example.education.presentation.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.education.R
import com.example.education.data.Student
import com.example.education.domain.usecase.function.seach.SearchByNameUseCase
import com.example.education.domain.usecase.function.sort.SortByMarkUseCase
import com.example.education.domain.usecase.function.sort.SortByNameUseCase
import com.example.education.domain.usecase.function.sort.SortByRandomUseCase
import com.example.education.presentation.adapter.StudentAdapter
import kotlinx.android.synthetic.main.fragment_students.*

class StudentsFragment : Fragment() {

    var students: ArrayList<Student> = ArrayList()
    private var rootStudents: ArrayList<Student> = ArrayList()
    var adapter : StudentAdapter? = null
    private var rootView : View? = null
    private val COUNT_BEST_STUDENTS = 50

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

        initializeData()
        initializeAdapter()
        initializeRecyclerView()
        initializeLayoutManager()

//        fab_fragment_students.setOnClickListener {
//            activity?.supportFragmentManager
//                ?.beginTransaction()
//                ?.hide(StudentsFragment())
//                ?.add(R.id.frameLayout_activity_main_container, AddFragment())
//                ?.commit()
//        }

        sortArrayByMarks()
    }

    fun addStudent(name1: String, surname: String, mark: Double, group1: String) {
        students.add(Student().apply { name = "$name1 $surname"; age = 20; avgMark = mark;
            group = group1; avatar = R.drawable.student_icon })
        Log.d("SIZE", students.size.toString())
        updateAdapter()
    }

    fun searchForName(searchText: String) {
        if(searchText == "" && students.size <= rootStudents.size)
            students = rootStudents
        else
            students = SearchByNameUseCase(students, searchText).search()
        updateAdapter()
    }

    fun sortStudentsByName() {
        students = SortByNameUseCase(students).sortByNameReverse()
        updateAdapter()
    }

    fun sortStudentsByMark() {
        students = SortByMarkUseCase(students).sortByMark()
        updateAdapter()
    }

    fun sortStudentsByRandom() {
        students = SortByRandomUseCase(students).sortByRandom()
        updateAdapter()
    }

    fun updateAdapter() {
        adapter!!.notifyDataSetChanged()
    }

    fun initializeAdapter(){
        adapter = StudentAdapter(students)
    }

    fun selector(s: Student): Double = s.avgMark

    private fun sortArrayByMarks() {
        var counter = 0
        val newStudents: ArrayList<Student> = ArrayList()

        students.sortByDescending {selector(it)}
        students.forEach {
            if(counter < COUNT_BEST_STUDENTS) {
                newStudents.add(it)
                counter++
            }
        }
        students.clear()
        students.addAll(newStudents)

        updateAdapter()
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
        rootStudents = students
    }

    private fun initializeLayoutManager(){
        recyclerview_fragment_students?.layoutManager = LinearLayoutManager(context)
    }

    private fun initializeRecyclerView(){
        recyclerview_fragment_students?.adapter = adapter
    }
}