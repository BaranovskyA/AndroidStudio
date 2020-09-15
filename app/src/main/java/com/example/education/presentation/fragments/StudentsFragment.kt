package com.example.education.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.education.R
import com.example.education.data.Student
import com.example.education.data.Subject
import com.example.education.domain.usecase.function.seach.SearchByNameUseCase
import com.example.education.domain.usecase.function.sort.SortByMarkUseCase
import com.example.education.domain.usecase.function.sort.SortByNameUseCase
import com.example.education.domain.usecase.function.sort.SortByRandomUseCase
import com.example.education.presentation.adapter.StudentAdapter
import kotlinx.android.synthetic.main.fragment_students.*

class StudentsFragment : BaseFragment() {
    var students: ArrayList<Student> = ArrayList()
    private var rootStudents: ArrayList<Student> = ArrayList()
    var adapter : StudentAdapter? = null
    private val COUNT_BEST_STUDENTS = 50

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_students, container, false)
        return rootView
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeData()
        initializeAdapter()
        initializeRecyclerView()
        initializeLayoutManager()

        sortArrayByMarks()
    }

    fun initializeFromSubject(s: Subject) {
        students.clear()
        rootStudents.clear()
        students.addAll(s.pupils)
        rootStudents.addAll(students)
        initializeAdapter()
        updateAdapter()
    }

    fun addStudent(name1: String, surname: String, mark: Double, group1: String, birthdate1: String) {
        students.add(Student().apply { name = "$name1 $surname"; avgMark = mark;
            group = group1; avatar = R.drawable.student_icon; birthdate = birthdate1 })
        rootStudents.clear()
        rootStudents.addAll(students)
        //updateAdapter()
    }

    fun searchForName(searchText: String) {
        if(searchText == "" && students.size <= rootStudents.size) {
            students.clear()
            students.addAll(rootStudents)
            sortArrayByMarks()
        }
        else {
            val newStudents = SearchByNameUseCase(students, searchText).search()
            students.clear()
            students.addAll(newStudents)
        }
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

    fun initializeData(): ArrayList<Student> {
        if(students.size == 0) {
            students.add(
                Student()
                    .apply { name = "Max Brown"; avatar =
                        R.drawable.student_icon; group = "SEP-171"; avgMark = 11.2; birthdate = "11.01.2001" } )
            students.add(
                Student()
                    .apply { name = "Cassie Gray"; avatar =
                        R.drawable.student_icon; group = "SEP-161"; avgMark = 8.2; birthdate = "11.01.2002" } )
            students.add(
                Student()
                    .apply { name = "John Green"; avatar =
                        R.drawable.student_icon; group = "SEP-191"; avgMark = 10.2; birthdate = "11.01.2000" })
            students.add(
                Student()
                    .apply { name = "Darvin Yellow"; avatar =
                        R.drawable.student_icon; group = "SEP-181"; avgMark = 12.0; birthdate = "11.01.2001" })
            students.add(
                Student()
                    .apply { name = "Bob Purple"; avatar =
                        R.drawable.student_icon; group = "SEP-161"; avgMark = 11.1; birthdate = "11.01.2003" })
            students.add(
                Student()
                    .apply { name = "Mike White"; avatar =
                        R.drawable.student_icon; group = "SEP-191"; avgMark = 11.6; birthdate = "11.01.2001" })
            students.add(
                Student()
                    .apply { name = "Mitchell Red"; avatar =
                        R.drawable.student_icon; group = "SEP-191"; avgMark = 9.8; birthdate = "11.01.2002" })
            students.add(
                Student()
                    .apply { name = "Ariana Blue"; avatar =
                        R.drawable.student_icon; group = "SEP-181"; avgMark = 10.4; birthdate = "11.01.2000" })
            students.add(
                Student()
                    .apply { name = "Michael Stone"; avatar =
                        R.drawable.student_icon; group = "SEP-171"; avgMark = 9.1; birthdate = "11.01.2000" })
            students.add(
                Student()
                    .apply { name = "Armando Tree"; avatar =
                        R.drawable.student_icon; group = "SEP-191"; avgMark = 8.5; birthdate = "11.01.2001" })
            rootStudents.addAll(students)
        }
        return students
    }

    private fun initializeLayoutManager(){
        recyclerview_fragment_students?.layoutManager = LinearLayoutManager(context)
    }

    private fun initializeRecyclerView(){
        recyclerview_fragment_students?.adapter = adapter
    }
}