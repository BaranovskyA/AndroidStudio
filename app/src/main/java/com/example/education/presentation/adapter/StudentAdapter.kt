package com.example.education.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.education.R
import com.example.education.data.Student
import com.example.education.presentation.holders.StudentViewHolder

class StudentAdapter ( var students: ArrayList<Student> = ArrayList() ) : RecyclerView.Adapter<StudentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int { return students.size }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        Log.d("SIZE ADAPTER", students.size.toString())
        Log.d("SIZE ADAPTER", students[position].name)
        holder.bindView(students[position])
}
}
