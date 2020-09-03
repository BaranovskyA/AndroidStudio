package com.example.education

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.fragment_group.view.*

class StudentGroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(student: Student) {
        itemView.textview_fragment_item_group?.text = student.group
    }
}