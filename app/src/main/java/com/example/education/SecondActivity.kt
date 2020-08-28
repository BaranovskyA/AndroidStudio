package com.example.education

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    var parameter: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initializeParameters()
        initializeData()
    }

    fun initializeParameters() {
        parameter = intent?.getStringExtra(MainActivity.KEY_PARAMETER) ?: ""
    }

    @SuppressLint("SetTextI18n")
    fun initializeData() {
        textview_activity_second.text = "Переданный параметр: $parameter"
    }
}