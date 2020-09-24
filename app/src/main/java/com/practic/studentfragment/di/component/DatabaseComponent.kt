package com.practic.studentfragment.di.component

import android.app.Application
import com.practic.studentfragment.EducationApplication
import com.practic.studentfragment.di.module.DatabaseModule
import dagger.Component


@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    fun inject(testApplication: EducationApplication?)

    fun getDatabaseName(): String?
}