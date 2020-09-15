package com.example.education.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

class Note {
    var title: String = ""
    var description: String = ""
    @RequiresApi(Build.VERSION_CODES.O)
    var dateDeadline: String = LocalDate.parse("2020-04-18").toString()
    var avatar : Int? = null
}