package com.example.education.domain.usecase.function.seach

import com.example.education.data.Student

class SearchByNameUseCase(var students: ArrayList<Student>, var search: String) {
    fun search(): ArrayList<Student> {
        search.trim(' ')
        val filtered = students.filter { it.name.toLowerCase().contains(search.toLowerCase())  }
        return ArrayList(filtered)
    }
}