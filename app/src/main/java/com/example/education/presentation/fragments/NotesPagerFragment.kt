package com.example.education.presentation.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.education.R
import com.example.education.data.Note
import kotlinx.android.synthetic.main.fragment_notes_pager.*
import java.time.LocalDate

class NotesPagerFragment : BaseFragment() {
    val ARGUMENT_NOTE_TITLE = "arg_note_title"
    val ARGUMENT_NOTE_DESCRIPTION = "arg_note_description"
    val ARGUMENT_NOTE_DEADLINE = "arg_note_deadline"

    fun newInstance(n: Note): NotesPagerFragment {
        val arguments = Bundle()
        arguments.putString(ARGUMENT_NOTE_TITLE, n.title)
        arguments.putString(ARGUMENT_NOTE_DESCRIPTION, n.description)
        arguments.putString(ARGUMENT_NOTE_DEADLINE, n.dateDeadline.toString())
        val pagerFragment: NotesPagerFragment = NotesPagerFragment()
        pagerFragment.arguments = arguments
        return pagerFragment
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_notes_pager, container, false)
        return rootView
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            textview_fragment_pager_note_title.text = arguments!!.getString(ARGUMENT_NOTE_TITLE)
            textview_fragment_pager_note_description.text = arguments!!.getString(ARGUMENT_NOTE_DESCRIPTION)
            textview_fragment_pager_note_date.text = arguments!!.getString(ARGUMENT_NOTE_DEADLINE)
            if(LocalDate.parse(arguments!!.getString(ARGUMENT_NOTE_DEADLINE)) <= LocalDate.now()) {
                textview_fragment_pager_note_date!!.setBackgroundResource(R.color.colorRed)
                textview_fragment_pager_note_date!!.setTextColor(Color.parseColor("#ffffff"))
            } else {
                textview_fragment_pager_note_date!!.setBackgroundResource(R.color.colorWhite)
                textview_fragment_pager_note_date!!.setTextColor(Color.parseColor("#000000"))
            }
        }
    }
}