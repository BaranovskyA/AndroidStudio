package com.example.education

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlin.math.log

class MainActivity2 : AppCompatActivity() {
    lateinit var login : EditText
    lateinit var password : EditText
    lateinit var buttonComplete : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        login = findViewById(R.id.edittext_activity_main2_login)
        password = findViewById(R.id.edittext_activity_main2_password)
        buttonComplete = findViewById(R.id.button_activity_main2_send)

        buttonComplete.setOnClickListener{
            sendDataMessage()
        }
    }

    private fun sendDataMessage(){
        if(login.length() > 0 && password.length() > 0) {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Your login: ${login.text}\nYour password: ${password.text}\nHave a nice day!"
            )

            startActivity(
                Intent.createChooser(
                    shareIntent,
                    "WhatsApp"
                )
            )
        }
    }
}