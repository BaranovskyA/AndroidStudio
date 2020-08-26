package com.example.education

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

// Assembly line (Конвеер)
class StudentsAdapter(var students: ArrayList<Student>) : RecyclerView.Adapter<StudentsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsHolder {
        Log.d("RecyclerView", "onCreateViewHolder")
        var view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_student, parent, false)
        return StudentsHolder(view)
    }

    override fun getItemCount(): Int { return students?.size }

    override fun onBindViewHolder(holder: StudentsHolder, position: Int) {
        Log.d("RecyclerView", "onBindViewHolder")
        holder.bind(students.get(position))
    }
}