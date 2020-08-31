package com.example.education

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeDefaultFragment()

        textview_activity_main_api_version.text = "v" + Build.VERSION.SDK_INT.toString()
    }

    private fun initializeDefaultFragment(){
        val fragment = StudentsFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout_activity_main_container,fragment)
            .commit()
    }
}