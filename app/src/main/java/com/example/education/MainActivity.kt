package com.example.education

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    lateinit var showStudents: TextView
    lateinit var sortStudents : Button
    lateinit var randomStudents : Button
    lateinit var layoutStudents: LinearLayout
    lateinit var listStudents: Student


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showStudents = findViewById(R.id.textview_student_list)
        sortStudents = findViewById(R.id.button_students_sort)
        randomStudents = findViewById(R.id.button_students_random)
        layoutStudents = findViewById(R.id.layout_students_list)
        listStudents = Student()

        showAllStudents()

        sortStudents.setOnClickListener{
            listStudents.sortStudents()
            showAllStudents()
        }

        randomStudents.setOnClickListener{
            listStudents.randomStudents()
            showAllStudents()
        }
    }

    fun showAllStudents(){

        layoutStudents.removeAllViews()

        listStudents.getAllStudents().forEach {
            showStudents = TextView(applicationContext)
            showStudents.text = it
            showStudents.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
            layoutStudents.addView(showStudents)
        }
    }
}