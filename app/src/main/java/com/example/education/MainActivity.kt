package com.example.education

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.widget.Button


class MainActivity : AppCompatActivity() {
    lateinit var buttonSend: Button

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSend = findViewById(R.id.button_activity_main_send)
        buttonSend.setOnClickListener {
            sendMessageWhatsApp()
        }
    }

    private fun sendMessageWhatsApp() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(
            Intent.EXTRA_TEXT,
            "Hello i have written Intent which sending you this message"
        )

        startActivity(
            Intent.createChooser(
                shareIntent,
                "WhatsApp"
            )
        )
    }
}