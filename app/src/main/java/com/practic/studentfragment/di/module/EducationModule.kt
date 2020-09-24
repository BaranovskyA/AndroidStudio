package com.practic.studentfragment.di.module

import com.practic.studentfragment.domain.Student
import dagger.Module
import dagger.Provides

@Module
class EducationModule {
    @Provides
    fun providesStudent() : Student {
        return Student()
    }

//    @Provides
//    fun initiateProvidesBackpack(dog: Dog) : Backpack{
//        return Backpack(dog)
//    }
//
//    @Provides
//    fun initiateProvidesDog(): Dog{
//        return Dog()
//    }
}