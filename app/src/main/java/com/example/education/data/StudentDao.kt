package com.example.education.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Insert
    fun initiateInsertStudent(student: Student)

    @Delete
    fun initiateDeleteStudent(student: Student)

    @Query("SELECT * FROM students")
    fun initiateGetStudents() : List<Student>
}