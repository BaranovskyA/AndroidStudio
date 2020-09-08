package com.example.education.data

import android.os.Build
import android.support.annotation.RequiresApi
import java.time.LocalDate

class Note {
    var title: String = ""
    var description: String = ""
    @RequiresApi(Build.VERSION_CODES.O)
    var dateDeadline: LocalDate = LocalDate.parse("2020-04-18")
    var avatar : Int? = null
}