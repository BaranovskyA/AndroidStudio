package com.example.education.domain.usecase.function.sort

import com.example.education.data.Student

class SortByNameUseCase(var students: ArrayList<Student>) {
    fun selector(s: Student): String = s.name

    fun sortByName(): ArrayList<Student>{
        students.sortByDescending { selector(it) }
        return students
    }

    fun sortByNameReverse(): ArrayList<Student>{
        students.sortBy { selector(it) }
        return students
    }
}