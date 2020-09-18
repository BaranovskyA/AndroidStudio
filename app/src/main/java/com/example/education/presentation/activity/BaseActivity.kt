package com.example.education.presentation.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.education.R
import com.example.education.presentation.fragments.*

abstract class BaseActivity : AppCompatActivity() {
    var cityFragment = CityFragment()
    var weatherFragment = WeatherFragment()

    var currentFragment: Fragment? = null
    var isVisibleFragment: Boolean = false

    @SuppressLint("ResourceType")
    fun displayFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.linearlayout_activity_main_container, cityFragment)
            .commit()
    }
}