package com.practic.studentfragment.presentation.interfaces

import com.practic.studentfragment.domain.Student

interface IStudentAdapterCallback {
    fun onMethodCallback(student: Student)
}