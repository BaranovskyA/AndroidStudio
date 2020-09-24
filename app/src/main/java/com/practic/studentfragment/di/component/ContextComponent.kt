package com.practic.studentfragment.di.component

import android.content.Context
import androidx.fragment.app.Fragment
import com.practic.studentfragment.di.module.ContextModule
import com.practic.studentfragment.presentation.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ContextModule::class])
interface ContextComponent {
    var context:Context
    fun injectContextFromFragment(fragment: Fragment)

    @Singleton
    fun injectContextFromActivity(mainActivity: MainActivity)
}