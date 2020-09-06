package com.example.education.domain.usecase.function.sort

import com.example.education.data.Student

class SortByMarkUseCase(var students: ArrayList<Student>) {
    fun selector(s: Student): Double = s.avgMark

    fun sortByMark(){
        students.sortByDescending { selector(it) }
    }

    fun sortByMarkReverse(){
        students.sortBy { selector(it) }
    }
}