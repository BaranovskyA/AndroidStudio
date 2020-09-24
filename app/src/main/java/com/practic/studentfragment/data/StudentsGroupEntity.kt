package com.practic.studentfragment.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class StudentsGroupEntity {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var title: String = ""
}