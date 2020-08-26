package com.example.education

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class StudentsFragment : Fragment() {

    var rootView: View? = null

    // Завод
    var recyclerView: RecyclerView? = null

    var adapter: StudentsAdapter? = null

    var students: ArrayList<Student> = ArrayList()

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
        initializeViews()
        initializeData()
        initializeAdapter()
        initializeRecyclerView()
        initializeLayoutManager()
    }

    fun initializeAdapter(){
        adapter = StudentsAdapter(students)
    }

    fun initializeData(){
        students.add(Student().apply { fullName = "Max Brown"; age = 19; course = 2 } )
        students.add(Student().apply { fullName = "Cassie Gray"; age = 18; course = 1} )
        students.add(Student().apply { fullName = "John Green"; age = 21; course = 4})
        students.add(Student().apply { fullName = "Darvin Yellow"; age = 20; course = 3})
        students.add(Student().apply { fullName = "Bob Purple"; age = 18; course = 1})
        students.add(Student().apply { fullName = "Mike White"; age = 21; course = 4})
        students.add(Student().apply { fullName = "Mitchell Red"; age = 21; course = 4})
        students.add(Student().apply { fullName = "Ariana Blue"; age = 20; course = 3})
        students.add(Student().apply { fullName = "Michael Stone"; age = 19; course = 2})
        students.add(Student().apply { fullName = "Armando Tree"; age = 21; course = 4})
    }

    fun initializeRecyclerView(){
        recyclerView?.adapter = adapter
    }

    fun initializeLayoutManager(){
        recyclerView?.layoutManager = LinearLayoutManager(context)
    }

    fun initializeViews(){
        recyclerView = rootView?.findViewById(R.id.recyclerview_fragment_students)
    }
}