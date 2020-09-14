package com.example.education.presentation.fragments

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.education.R
import com.example.education.data.Note
import com.example.education.presentation.adapter.NoteAdapter
import kotlinx.android.synthetic.main.fragment_notes.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class NotesFragment : BaseFragment() {

    var notes: ArrayList<Note> = ArrayList()
    var adapter : NoteAdapter? = null
    private val COUNT_BEST_STUDENTS = 50

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_notes, container, false)
        return rootView
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeData()
        initializeAdapter()
        initializeRecyclerView()
        initializeLayoutManager()

        //sortArrayByDate()
    }

    fun addNote(title1: String, description1: String, deadline: String) {
        notes.add(Note().apply { title = title1; description = description1; dateDeadline = deadline })
        updateAdapter()
    }

    fun updateAdapter() {
        adapter!!.notifyDataSetChanged()
    }

    fun initializeAdapter(){
        adapter = NoteAdapter(notes)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun selector(n: Note): LocalDate = LocalDate.parse(n.dateDeadline)

    @RequiresApi(Build.VERSION_CODES.O)
    private fun sortArrayByDate() {
        var counter = 0
        val newNotes: ArrayList<Note> = ArrayList()

        notes.sortByDescending {selector(it)}
        notes.forEach {
            if(counter < COUNT_BEST_STUDENTS) {
                newNotes.add(it)
                counter++
            }
        }
        notes.clear()
        notes.addAll(newNotes)

        updateAdapter()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SimpleDateFormat")
    fun initializeData(): ArrayList<Note> {
        if(notes.size == 0) {
            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
            notes.add(Note().apply { title = "Note 1"; description = "This is Note 1"; dateDeadline = LocalDate.now().format(formatter).toString(); avatar = R.drawable.ic_baseline_assignment_24 })
            notes.add(Note().apply { title = "Note 2"; description = "This is Note 2"; dateDeadline = LocalDate.now().minusYears(3).format(formatter).toString(); avatar = R.drawable.ic_baseline_assignment_24 })
            notes.add(Note().apply { title = "Note 3"; description = "This is Note 3"; dateDeadline = LocalDate.now().plusDays(18).format(formatter).toString(); avatar = R.drawable.ic_baseline_assignment_24 })
            notes.add(Note().apply { title = "Note 4"; description = "This is Note 4"; dateDeadline = LocalDate.now().format(formatter).toString(); avatar = R.drawable.ic_baseline_assignment_24 })
            notes.add(Note().apply { title = "Note 5"; description = "This is Note 5"; dateDeadline = LocalDate.now().format(formatter).toString(); avatar = R.drawable.ic_baseline_assignment_24 })
        }
        return notes
    }

    private fun initializeLayoutManager(){
        recyclerview_fragment_notes?.layoutManager = LinearLayoutManager(context)
    }

    private fun initializeRecyclerView(){
        recyclerview_fragment_notes?.adapter = adapter
    }
}