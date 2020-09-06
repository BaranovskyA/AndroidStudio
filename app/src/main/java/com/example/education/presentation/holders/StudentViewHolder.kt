package com.example.education.presentation.holders

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.education.data.Student
import kotlinx.android.synthetic.main.fragment_item.view.*

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n")
    fun bindView(student: Student) {
        student.avatar?.let { itemView.imageview_fragment_item_avatar.setImageResource(it) }
        itemView.textview_fragment_item_name?.text = student.name
        itemView.textview_fragment_item_age?.text = "Age: ${student.age}"
        itemView.textview_fragment_item_mark?.text = "Average mark: ${student.avgMark}"
    }
}