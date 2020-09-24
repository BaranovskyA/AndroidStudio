package com.practic.studentfragment.domain.usecase

import android.content.Context
import com.practic.studentfragment.domain.Student

class StudentsSortUseCase {
    fun initiateSortStudentsByName(students: ArrayList<Student>) : ArrayList<Student>? {
        return students.apply { sortBy{student ->  student.name} }
    }

    fun initiateSortStudentsRandom(students: ArrayList<Student>) : ArrayList<Student>? {
        return students.apply { shuffle() }
    }

}