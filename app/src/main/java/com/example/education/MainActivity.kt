package com.example.education

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.speech.SpeechRecognizer
import android.widget.TextView
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var speechText: TextView
    lateinit var buttonSpeech: Button
    var REQUEST_CODE_SPEECH = 102

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        initializeListeners()
    }

    private fun initializeViews() {
        speechText = findViewById(R.id.textview_activity_main_text)
        buttonSpeech = findViewById(R.id.button_activity_main_speech)
    }

    private fun initializeListeners(){
        buttonSpeech.setOnClickListener{
            speak()
        }
    }

    private fun speak() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say something")

        try{
            startActivityForResult(intent,REQUEST_CODE_SPEECH)
        }catch (e:Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            REQUEST_CODE_SPEECH->{
                if(resultCode == Activity.RESULT_OK && null != data){
                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    speechText.text = result!![0]
                }
            }
        }
    }
}