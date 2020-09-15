package com.example.education.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Subject {
    @PrimaryKey(autoGenerate = true) var subjectId: Int = 0
    var title: String = ""
    var pupils: ArrayList<Student> = ArrayList()
}