package com.example.education.domain.usecase.function.sort

import com.example.education.data.Student

class SortByNameUseCase(var students: ArrayList<Student>) {
    fun selector(s: Student): String = s.name

    fun sortByName(){
        students.sortByDescending { selector(it) }
    }

    fun sortByNameReverse(){
        students.sortBy { selector(it) }
    }
}