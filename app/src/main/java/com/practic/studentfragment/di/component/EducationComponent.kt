package com.practic.studentfragment.di.component

import com.practic.studentfragment.di.module.EducationModule
import com.practic.studentfragment.domain.Student
import com.practic.studentfragment.presentation.fragments.LoginFragment
import dagger.Component


@Component(modules = [EducationModule::class])
interface EducationComponent {
//    public fun injectBackpack() : Backpack

    public fun injectStudent() : Student

    public fun inject(loginFragment: LoginFragment)
}