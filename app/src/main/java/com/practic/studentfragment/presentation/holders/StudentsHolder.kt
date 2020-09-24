package com.practic.studentfragment.presentation.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.practic.studentfragment.domain.Student
import kotlinx.android.synthetic.main.viewholder_student.view.*

// Каркас
class StudentsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(student: Student) {
        itemView.textview_viewholder_student_name?.text = student.name
        itemView.imageview_viewholder_student_avatar.setImageBitmap(student.image)
    }
}