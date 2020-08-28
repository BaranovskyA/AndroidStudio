package com.example.education

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        val KEY_PARAMETER = "com.example.education.PARAMETER"
        val KEY_REQUEST_CODE = 1001
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_activity_main_get.setOnClickListener {
            goTo()
        }

        textview_activity_main_api_version.text = "v" + Build.VERSION.SDK_INT.toString()
    }

    fun goTo() {
        var intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(KEY_PARAMETER, "Baranovsky")
        startActivityForResult(intent, KEY_REQUEST_CODE)
    }

}