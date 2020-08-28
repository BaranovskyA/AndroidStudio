package com.example.education

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_photo.*

class PhotoActivity : AppCompatActivity() {
    private val CAMERA = Manifest.permission.CAMERA
    private val CALL_PHONE = Manifest.permission.CALL_PHONE
    private val PERMISSION_REQUEST = 200

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        requestPermissions(arrayOf(CAMERA, CALL_PHONE), PERMISSION_REQUEST)

        button_activity_photo_capture.setOnClickListener {
            openCamera()
        }
    }

    fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, PERMISSION_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            var photo: Bitmap = data?.extras?.get("data") as Bitmap
            imageview_activity_photo.setImageBitmap(photo)
        }
    }
}