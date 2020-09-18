package com.example.education.presentation.fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.view.WindowManager
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.example.education.R
import io.reactivex.annotations.NonNull
import kotlinx.android.synthetic.main.fragment_dialog.*

class CustomDialogFragment: DialogFragment() {
    var editText: EditText? = null
    var onOk: (() -> Unit)? = null

    @SuppressLint("InflateParams")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = activity!!.layoutInflater.inflate(R.layout.fragment_dialog, null)

        val builder: AlertDialog.Builder = AlertDialog.Builder(context!!)
            .setView(view)
            .setPositiveButton("ADD LOCATION"
            ) { _, _ ->
                editText?.text = Editable.Factory.getInstance().newEditable("Brazilia,br")
                onOk?.invoke()
            }
            .setNegativeButton("CANCEL", null)

        return builder.create()
    }


}