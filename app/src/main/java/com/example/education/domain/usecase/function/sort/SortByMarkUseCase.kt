package com.example.education.domain.usecase.function.sort

import com.example.education.data.Student

class SortByMarkUseCase(var students: ArrayList<Student>) {
    fun selector(s: Student): Double = s.avgMark

    fun sortByMark(): ArrayList<Student>{
        students.sortByDescending { selector(it) }
        return students
    }

    fun sortByMarkReverse(): ArrayList<Student>{
        students.sortBy { selector(it) }
        return students
    }
}