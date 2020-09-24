package com.practic.studentfragment.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.practic.studentfragment.presentation.fragments.LoginFragment
import com.practic.studentfragment.R
import com.practic.studentfragment.di.component.DaggerContextComponent

class MainActivity : AppCompatActivity() {

    var frameLayoutFragmentContainer: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        initializeDefaultFragment()
    }

    fun initializeViews() {
        frameLayoutFragmentContainer =
            findViewById(R.id.framelayout_activity_main_fragment_container)
    }

    fun initializeDefaultFragment() {
        var loginFragment = LoginFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.framelayout_activity_main_fragment_container, loginFragment)
            .commit()
    }
}