package com.example.education

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OutputCardActivity : AppCompatActivity() {
    var textViewName: TextView? = null
    var textViewSurname: TextView? = null

    var name: String = ""
    var surname: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output_card)

        initializeViews()
        initializeArguments()
        initializeData()
    }

    fun initializeViews() {
        textViewName = findViewById(R.id.textview_output_card_name)
        textViewSurname = findViewById(R.id.textview_output_card_surname)
    }

    fun initializeArguments(){
        name = intent?.getStringExtra(InputCardActivity.KEY_NAME) ?: ""
        surname = intent?.getStringExtra(InputCardActivity.KEY_SURNAME) ?: ""
    }

    fun initializeData(){
        textViewName?.text = name
        textViewSurname?.text = surname
        val intent = Intent()
        intent.putExtra(InputCardActivity.KEY_RESULT_DATE, "okay")
        setResult(InputCardActivity.KEY_RESULT_CODE, intent)
    }
}