package com.practic.studentfragment.di.component

import dagger.Component
import com.practic.studentfragment.di.module.UseCaseModule
import com.practic.studentfragment.domain.usecase.StudentsSortUseCase
import com.practic.studentfragment.presentation.fragments.StudentsFragment

@Component(modules = [UseCaseModule::class])
interface UseCaseComponent {
    fun initiateReturnStudentsUseCase(): StudentsSortUseCase

    fun inject(studentsFragment: StudentsFragment)
}