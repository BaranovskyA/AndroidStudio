package com.example.education

import android.graphics.Color
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var login: EditText
    lateinit var password: EditText
    lateinit var text: TextView
    lateinit var button: Button
    private var isViewVisible: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login = findViewById(R.id.edittext_login)
        password = findViewById(R.id.edittext_password)
        text = findViewById(R.id.textview_message)
        button = findViewById(R.id.button_OK)
    }

    fun changeVisibility(view: View) {
        if (isViewVisible) {
            login.visibility = View.INVISIBLE
            password.visibility = View.INVISIBLE
            text.visibility = View.INVISIBLE
            button.visibility = View.INVISIBLE
        } else {
            login.visibility = View.VISIBLE
            password.visibility = View.VISIBLE
            text.visibility = View.VISIBLE
            button.visibility = View.VISIBLE
        }
        isViewVisible = !isViewVisible
    }

    fun nameCheck(view: View) {
        if(login.text.toString() == "icarus" && password.text.toString() == "fallen")
        {
            text.text = "It's so sad =("
        } else {
            text.text = ""
        }
    }
}