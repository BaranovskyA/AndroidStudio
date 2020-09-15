package com.example.education.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Query("SELECT * FROM students")
    fun initiateGetStudents() : ArrayList<Student>

    @Query("SELECT * FROM subjects")
    fun initiateGetSubjects() : ArrayList<Subject>

    @Query("SELECT * FROM students WHERE studentId = id")
    fun initiateGetStudentById(id: Int) : Student

    @Query("SELECT * FROM subjects WHERE subjectId = id")
    fun initiateGetSubjectById(id: Int) : Subject

    @Query("DELETE FROM students")
    fun initiateDeleteStudents()

    @Query("DELETE FROM subjects")
    fun initiateDeleteSubjects()

    @Query("DELETE FROM students WHERE studentId = id")
    fun initiateDeleteStudentById(id: Int)

    @Query("DELETE FROM subjects WHERE subjectId = id")
    fun initiateDeleteSubjectById(id: Int)

    @Insert
    fun initiateInsertStudent(student: Student)

    @Insert
    fun initiateInsertListStudents(students: ArrayList<Student>)

    @Insert
    fun initiateInsertSubject(subject: Subject)

    @Insert
    fun initiateInsertListSubjects(subjects: ArrayList<Subject>)
}