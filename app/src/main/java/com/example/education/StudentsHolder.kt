package com.example.education

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.viewholder_student.*
import kotlinx.android.synthetic.main.viewholder_student.view.*

// Каркас
class StudentsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n")
    fun bind(student: Student){
        itemView.textview_viewholder_student_name?.text = "Name: ${student.fullName}"
        itemView.textview_viewholder_student_age?.text = "Age: ${student.age}"
        itemView.textview_viewholder_student_course?.text = "Course: ${student.course}"
    }
}