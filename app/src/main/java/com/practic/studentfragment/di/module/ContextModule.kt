package com.practic.studentfragment.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule {
    private lateinit var context: Context

    fun ContextModule(context: Context) {
        this.context = context
    }

    @Provides
    fun initiateProvidesContext() : Context {
        return context
    }

}