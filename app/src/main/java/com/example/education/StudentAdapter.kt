package com.example.education

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class StudentAdapter ( private val students: ArrayList<Student> ) : RecyclerView.Adapter<StudentViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bindView(students[position])
    }

    override fun getItemCount(): Int = students.size
}
