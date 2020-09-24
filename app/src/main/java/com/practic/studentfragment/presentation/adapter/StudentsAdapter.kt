package com.practic.studentfragment.presentation.adapter

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.practic.studentfragment.presentation.interfaces.IStudentAdapterCallback
import com.practic.studentfragment.R
import com.practic.studentfragment.presentation.holders.StudentsHolder
import com.practic.studentfragment.domain.Student
import kotlinx.android.synthetic.main.viewholder_student.view.*


class StudentsAdapter(var students: ArrayList<Student>, var callback: IStudentAdapterCallback) :
    RecyclerView.Adapter<StudentsHolder>() {

    constructor(
        context: Context?,
        students: ArrayList<Student>,
        callback: IStudentAdapterCallback
    ) : this(students, callback) {
        this.callback = callback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsHolder {
        var view = LayoutInflater.from(parent.context).inflate(
            R.layout.viewholder_student,
            parent,
            false
        )

        return StudentsHolder(view)
    }


    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: StudentsHolder, position: Int) {
        holder.bind(students[position])

        holder.itemView.setOnClickListener(View.OnClickListener {
            var selectedStudent: Student = Student()
            selectedStudent.name = holder.itemView.textview_viewholder_student_name.text.toString()
            selectedStudent.image =
                (holder.itemView.imageview_viewholder_student_avatar.drawable as BitmapDrawable).bitmap
            callback?.onMethodCallback(selectedStudent)
        })

    }
}