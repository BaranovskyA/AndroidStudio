package com.example.education.presentation.activity

import android.os.Bundle
import com.example.education.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayFragment()
    }
}