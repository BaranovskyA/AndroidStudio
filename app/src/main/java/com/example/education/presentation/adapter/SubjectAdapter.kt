package com.example.education.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.education.R
import com.example.education.data.Subject
import com.example.education.presentation.activity.MainActivity
import com.example.education.presentation.holders.SubjectViewHolder


class SubjectAdapter(var subjects: ArrayList<Subject> = ArrayList(), activity: MainActivity) : RecyclerView.Adapter<SubjectViewHolder>() {
    var refActivity = activity
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_subject, parent, false)
        return SubjectViewHolder(view, refActivity)
    }

    override fun getItemCount(): Int { return subjects.size }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.bindView(subjects[position])
    }
}