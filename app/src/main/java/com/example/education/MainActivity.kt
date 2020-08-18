package com.example.education

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.Manifest
import android.os.Build
import android.support.annotation.RequiresApi


class MainActivity : AppCompatActivity() {

    lateinit var phoneNumber: EditText
    lateinit var cameraButton: Button
    lateinit var clickImage: ImageView
    private val CAMERA = Manifest.permission.CAMERA
    private val CALL_PHONE = Manifest.permission.CALL_PHONE
    private val PERMISSION_REQUEST = 200

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermissions(arrayOf(CAMERA, CALL_PHONE), PERMISSION_REQUEST)

        phoneNumber = findViewById(R.id.edittext_phone_number)
        cameraButton = findViewById(R.id.button_camera)
        clickImage = findViewById(R.id.imageview_camera)
    }

    fun callOnNumber(view: View) {
        val toDial = "tel:" + phoneNumber.getText().toString()
        startActivity(Intent(Intent.ACTION_CALL, Uri.parse(toDial)))
    }

    fun openCamera(view: View) {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, PERMISSION_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            var photo:Bitmap = data?.extras?.get("data") as Bitmap
            clickImage.setImageBitmap(photo)
        }
    }
}