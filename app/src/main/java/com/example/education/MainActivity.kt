package com.example.education

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
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
        Log.d("LIFE", "onCreate")
        setContentView(R.layout.activity_main)

        edittextName = findViewById(R.id.edittext_activity_main_name)
        edittextSurname = findViewById(R.id.edittext_activity_main_surname)
        buttonAction = findViewById(R.id.button_activity_main_fill_data)

        buttonAction?.setOnClickListener {
            initiateTransitionDetailActivity()
        }
    }

    fun initiateTransitionDetailActivity(){
        if(edittextName?.text?.toString()?.length ?: 0 > 0 && edittextSurname?.text?.toString()?.length ?: 0 > 0) {
            var intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(KEY_NAME, edittextName?.text.toString())
            intent.putExtra(KEY_SURNAME, edittextSurname?.text.toString())
            startActivityForResult(intent, KEY_REQUEST_CODE) //explicit
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == KEY_REQUEST_CODE){
            if(resultCode == KEY_RESULT_CODE){
                Log.d("DATA", data?.getStringExtra(KEY_RESULT_DATE) ?: "")
            }
        }
    }
}