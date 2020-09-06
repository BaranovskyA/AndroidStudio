package com.example.education.domain

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class SpeechRecognizerHelper : AppCompatActivity() {

    private val REQUEST_CODE_SPEECH = 102
    private val RECOGNIZER_REQUEST_CODE = 103
    private val speech_layout: Int? = null
    private val speech_button: Button? = null
    private val text_view: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (speech_layout != null) {
            setContentView(speech_layout)
        }

        speech_button?.setOnClickListener { speak() }
    }


    fun speak() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say something")

        try{
            startActivityForResult(intent,REQUEST_CODE_SPEECH)
        } catch (e:Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                RECOGNIZER_REQUEST_CODE -> {
                    val extras = data?.getExtras()
                    val text = extras?.get("data") as TextView
                    text_view?.text = text.text
                }
            }
        }
    }

}