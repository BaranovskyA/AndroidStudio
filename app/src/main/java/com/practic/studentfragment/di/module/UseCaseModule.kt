package com.practic.studentfragment.di.module

import com.practic.studentfragment.domain.usecase.StudentsSortUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun providesStudentsSortUseCase() : StudentsSortUseCase{
        return StudentsSortUseCase()
    }
}