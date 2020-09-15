package com.example.education.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Student::class), version = 2)
abstract class EducationDatabase : RoomDatabase(){
    abstract fun getStudentDao(): StudentDao
}