package com.practic.studentfragment.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StudentEntity::class, StudentsGroupEntity::class], version = 2)
abstract class EducationDatabase : RoomDatabase(){
    abstract fun getStudentDao(): StudentDao
}