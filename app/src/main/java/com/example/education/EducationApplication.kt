package com.example.education

import androidx.multidex.MultiDexApplication
import androidx.room.Room
import com.example.education.data.EducationDatabase

class EducationApplication : MultiDexApplication() {

    var db: EducationDatabase? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        db = Room.databaseBuilder(this, EducationDatabase::class.java, "education.db").build()
    }

    companion object {
        val TAG = EducationApplication::class.java.simpleName

        lateinit var instance: EducationApplication
            private set
    }
}