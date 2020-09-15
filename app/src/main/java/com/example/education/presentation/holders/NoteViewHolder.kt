package com.example.education.presentation.holders

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.education.R
import com.example.education.data.Note
import kotlinx.android.synthetic.main.fragment_item_note.view.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class NoteViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n", "SimpleDateFormat", "ResourceAsColor")
    fun bindView(note: Note) {
        val splitted = note.dateDeadline.split('.')
        var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        //note.avatar?.let { itemView.imageview_fragment_item_note.setImageResource(it) }
        itemView.textview_fragment_item_note_title!!.text = note.title
        itemView.textview_fragment_item_note_description!!.text = note.description
        itemView.textview_fragment_item_note_date!!.text = note.dateDeadline.toString()
        if(splitted[0].toInt() < 10 && splitted[1].toInt() < 10) {
            formatter = DateTimeFormatter.ofPattern("d.M.yyyy")
        } else if(splitted[0].toInt() > 9 && splitted[1].toInt() < 10) {
            formatter = DateTimeFormatter.ofPattern("dd.M.yyyy")
        }

        if(LocalDate.parse(note.dateDeadline, formatter).isBefore(LocalDate.now())) {
            itemView.textview_fragment_item_note_date!!.setBackgroundResource(R.color.colorRed)
            itemView.textview_fragment_item_note_date!!.setTextColor(Color.parseColor("#ffffff"))
        } else {
            itemView.textview_fragment_item_note_date!!.setBackgroundResource(R.color.colorWhite)
            itemView.textview_fragment_item_note_date!!.setTextColor(Color.parseColor("#000000"))
        }
    }
}