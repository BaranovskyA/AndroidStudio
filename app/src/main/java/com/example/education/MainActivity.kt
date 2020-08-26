package com.example.education

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeDefaultFragment()
    }

    fun initializeDefaultFragment(){
        var studentsFragment = StudentsFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.framelayout_activity_main_fragment_container, studentsFragment)
            .commit()
    }
}