package com.example.education

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class InputCardActivity : AppCompatActivity() {
    var imageviewSelfie: ImageView? = null
    var edittextName: EditText? = null
    var edittextSurname: EditText? = null
    var buttonAction: Button? = null

    companion object{
        val KEY_NAME = "com.example.education.NAME"
        val KEY_SURNAME = "com.example.education.SURNAME"
        val KEY_REQUEST_CODE = 1001
        val KEY_RESULT_CODE = 1002
        val KEY_RESULT_DATE = "com.example.education.DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_card)

        initializeViews()

        buttonAction?.setOnClickListener {
            initiateTransitionOutputCardActivity()
        }
    }

    fun initiateTransitionOutputCardActivity(){
        if(edittextName?.text?.toString()?.length ?: 0 > 0 && edittextSurname?.text?.toString()?.length ?: 0 > 0) {
            var intent = Intent(this, OutputCardActivity::class.java)
            intent.putExtra(KEY_NAME, edittextName?.text.toString())
            intent.putExtra(KEY_SURNAME, edittextSurname?.text.toString())
            startActivityForResult(intent, KEY_REQUEST_CODE)
        }
    }

    fun initializeViews() {
        imageviewSelfie = findViewById(R.id.imageview_input_card_selfie)
        edittextName = findViewById(R.id.edittext_input_card_name)
        edittextSurname = findViewById(R.id.edittext_input_card_surname)
        buttonAction = findViewById(R.id.button_input_card_register)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == MainActivity.KEY_REQUEST_CODE){
            if(resultCode == MainActivity.KEY_RESULT_CODE){
                Log.d("DATA", data?.getStringExtra(MainActivity.KEY_RESULT_DATE) ?: "")
            }
        }
    }
}