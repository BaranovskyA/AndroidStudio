package com.example.education.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Student {
    @PrimaryKey(autoGenerate = true) var studentId: Int = 0
    var name : String = ""
    var birthdate : String = ""
    var avatar : Int? = null
    var group : String = ""
    var avgMark : Double = 0.0
}

