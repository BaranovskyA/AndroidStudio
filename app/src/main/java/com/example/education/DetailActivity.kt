package com.example.education

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    var textViewName: TextView? = null
    var textViewSurname: TextView? = null

    var name: String = ""
    var surname: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initializeArguments()
        initializeViews()
        initializeData()
    }

    fun initializeViews(){
        textViewName = findViewById(R.id.textview_activity_detail_name)
        textViewSurname = findViewById(R.id.textview_activity_detail_surname)
    }

    fun initializeArguments(){
        name = intent?.getStringExtra(MainActivity.KEY_NAME) ?: ""
        surname = intent?.getStringExtra(MainActivity.KEY_SURNAME) ?: ""
    }

    fun initializeData(){
        textViewName?.text = name
        textViewSurname?.text = surname
        val intent = Intent()
        intent.putExtra(MainActivity.KEY_RESULT_DATE, "okay")
        setResult(MainActivity.KEY_RESULT_CODE, intent)
    }
}