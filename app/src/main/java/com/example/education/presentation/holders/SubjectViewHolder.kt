package com.example.education.presentation.holders

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.education.data.Subject
import com.example.education.presentation.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_item_subject.view.*

class SubjectViewHolder(itemView: View, activity: MainActivity) : RecyclerView.ViewHolder(itemView) {
    var refActivity: MainActivity = activity
    @SuppressLint("SetTextI18n")
    fun bindView(subject: Subject) {
        itemView.textview_fragment_item_subject.text = "${subject.title}  ${subject.pupils.count()} students"
        itemView.textview_fragment_item_subject.setOnClickListener {
            Log.d("SUBJECT", subject.title)
            //refActivity.initializeStudentsFragment(subject)
        }
    }


}