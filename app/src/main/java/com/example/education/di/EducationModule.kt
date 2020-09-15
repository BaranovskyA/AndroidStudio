package com.example.education.di

import dagger.Module
import dagger.Provides
import com.example.education.data.Student
import com.example.education.data.Subject

@Module
class EducationModule {

    @Provides
    fun providesSubject(students: ArrayList<Student>) : Subject{
        return Subject().apply { pupils = students }
    }
}