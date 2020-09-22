package com.example.education.presentation.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.education.R
import com.example.education.data.City
import com.example.education.presentation.fragments.*

abstract class BaseActivity : AppCompatActivity() {
    var cityFragment = CityFragment(this)
    var weatherFragment = WeatherFragment(City("",""), this)

    @SuppressLint("ResourceType")
    fun displayFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.linearlayout_activity_main_container, cityFragment)
            .commit()
    }
}