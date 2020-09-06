package com.example.education.domain

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class SocialNetworkHelper : AppCompatActivity() {
    private val whatsapp_layout: Int? = null
    private val send_button: Button? = null
    private val edittext: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (whatsapp_layout != null) {
            setContentView(whatsapp_layout)
        }

        send_button?.setOnClickListener { onClick() }
    }


    fun onClick() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(
            Intent.EXTRA_TEXT,
            edittext?.text
        )

        startActivity(
            Intent.createChooser(
                shareIntent,
                "WhatsApp"
            )
        )
    }
}