package com.example.education

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        val KEY_PARAMETER = "com.example.education.PARAMETER"
        val KEY_REQUEST_CODE = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_activity_main_get.setOnClickListener {
            goTo()
        }
    }

    fun goTo() {
        var intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(KEY_PARAMETER, "Baranovsky")
        startActivityForResult(intent, KEY_REQUEST_CODE)
    }

}