package com.example.education

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class StudentAdapter ( private val students: ArrayList<Student> ) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    val STUDENT_TYPE = 1
    val GROUP_TYPE = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View? = null
        when(viewType) {
            GROUP_TYPE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_group, parent, false)
                return StudentGroupViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item, parent, false)
                return StudentViewHolder(view)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position % 2) {
            0 -> GROUP_TYPE
            else -> STUDENT_TYPE
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(position % 2) {
            GROUP_TYPE -> {(holder as StudentGroupViewHolder).bindView(students[position])}
            STUDENT_TYPE -> {(holder as StudentViewHolder).bindView(students[position - 1])}
        }
    }

    override fun getItemCount(): Int = students.size
}
