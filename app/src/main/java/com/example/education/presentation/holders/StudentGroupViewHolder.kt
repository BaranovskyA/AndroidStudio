package com.example.education.presentation.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.education.data.Student
import kotlinx.android.synthetic.main.fragment_group.view.*

class StudentGroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(student: Student) {
        itemView.textview_fragment_item_group?.text = student.group
    }
}