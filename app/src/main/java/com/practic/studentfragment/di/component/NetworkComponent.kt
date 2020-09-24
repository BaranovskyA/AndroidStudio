package com.practic.studentfragment.di.component

import com.practic.studentfragment.EducationApplication
import com.practic.studentfragment.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface NetworkComponent {
    fun inject(app: EducationApplication)
}