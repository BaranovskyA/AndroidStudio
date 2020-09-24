package com.practic.studentfragment.presentation.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.practic.studentfragment.R
import com.practic.studentfragment.data.api.ApiConnection
import com.practic.studentfragment.domain.CurrencyObject
import com.practic.studentfragment.domain.Student
import java.io.IOException


class LoginFragment : Fragment() {

    var buttonAction: Button? = null
    var student: Student = Student()
    private val PICK_IMAGE_REQUEST = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = LayoutInflater.from(context).inflate(R.layout.fragment_login, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonAction = view.findViewById(R.id.button_activity_main_fill_data)
        val imageView: ImageView? = view.findViewById(R.id.imageview_login_student_avatar)
        val edittextName: EditText? = view.findViewById(R.id.edittext_activity_main_name)
        imageView?.setOnClickListener {
            chooseImage()
        }

        buttonAction?.setOnClickListener {
            student.name = edittextName?.text.toString()
            sendStudent(student)
        }
    }



    fun sendStudent(student: Student) {

        var fragment: StudentsFragment = StudentsFragment()
        var bundle: Bundle = Bundle()
        bundle.putParcelable("studentFromLoginFragment", student)
        fragment.arguments = bundle

        fragmentManager?.beginTransaction()?.add(
            R.id.framelayout_activity_main_fragment_container,
            fragment
        )?.hide(this)?.addToBackStack("studentFragment")?.commit()
    }

    fun chooseImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            val uri: Uri? = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(context?.contentResolver, uri)
                student.image = bitmap
                val imageView: ImageView? = view?.findViewById(R.id.imageview_login_student_avatar)
                imageView?.setImageBitmap(Bitmap.createScaledBitmap(bitmap, 400, 400, false))
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

}