package com.example.education.presentation.adapter

import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.education.R
import com.example.education.data.Note
import com.example.education.presentation.holders.NoteViewHolder

class NoteAdapter( var notes: ArrayList<Note> = ArrayList() ) : RecyclerView.Adapter<NoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int { return notes.size }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bindView(notes[position])
    }
}