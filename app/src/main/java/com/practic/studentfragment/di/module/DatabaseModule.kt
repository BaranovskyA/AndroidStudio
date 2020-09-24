package com.practic.studentfragment.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.practic.studentfragment.data.EducationDatabase
import com.practic.studentfragment.data.StudentDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule(val application: Application) {

    private var mContext: Context = application.applicationContext

    private val mDBName = "education.db"

    fun DatabaseModule(context: Context) {
        mContext = context
    }

    @Singleton
    @Provides
    fun provideDatabase(): EducationDatabase? {
        return Room.databaseBuilder<EducationDatabase>(
            mContext,
            EducationDatabase::class.java,
            mDBName
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideDatabaseName(): String? {
        return mDBName
    }

    @Singleton
    @Provides
    fun providePersonDao(db: EducationDatabase): StudentDao? {
        return db.getStudentDao()
    }

}