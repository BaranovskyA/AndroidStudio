package com.practic.studentfragment

import androidx.multidex.MultiDexApplication
import androidx.room.Room
import com.practic.studentfragment.data.EducationDatabase
import com.practic.studentfragment.di.component.DaggerNetworkComponent
import com.practic.studentfragment.di.component.NetworkComponent

class EducationApplication : MultiDexApplication() {

    companion object {
        lateinit var instance: EducationApplication
            private set
    }

    lateinit var appComponent: NetworkComponent
        private set


    var db: EducationDatabase? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        initComponent()
        db = Room.databaseBuilder(this, EducationDatabase::class.java, "education.db").build()
    }

    private fun initComponent() {
        appComponent = DaggerNetworkComponent.builder()
            .build()
        appComponent.inject(this)
    }

}