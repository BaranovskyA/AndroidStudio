package com.example.education

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.edittext_name)
        text = findViewById(R.id.textview_message)
    }

    fun nameCheck(view: View) {
        if(Pattern.compile("[0-9]").matcher(name.text).find())
        {
            text.setTextColor(Color.RED)
            text.text = "Error, we have digits in our name!"
        } else {
            text.setTextColor(Color.GREEN)
            text.text = "Everithing looks fine!"
        }
    }
}