package com.example.education.domain.usecase.function.sort

import com.example.education.data.Student

class SortByRandomUseCase(var students: ArrayList<Student>) {
    fun sortByRandom(){
        students.shuffle()
    }
}