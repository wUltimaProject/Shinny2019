package com.wultimaproject.shinny2019.common.dependencyinjection.application

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.wultimaproject.shinny2019.ShinnyApplication
import com.wultimaproject.shinny2019.model.db.ContactDao
import com.wultimaproject.shinny2019.model.db.ShinnyDatabase
import com.wultimaproject.shinny2019.ui.repositories.DbRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import dagger.Binds


@Module
class ApplicationModule(private val baseApp: ShinnyApplication) {


    @Singleton
    @Provides
    fun provideApplication(): ShinnyApplication{
        return baseApp
    }

    @Singleton
    @Provides
    fun provideContext(): Context{
        return baseApp.baseContext
    }

    @Provides
    @Singleton
    fun provideShinnyDatabase(context: Context): ShinnyDatabase = Room.databaseBuilder(context,
        ShinnyDatabase::class.java,
        "ShinnyDatabase.db")
        .build()


    @Singleton
    @Provides
    fun provideContactDao(appDatabase: ShinnyDatabase): ContactDao {
        return appDatabase.contactDao()
    }


    @Provides
    fun provideDbRepository(contactDao: ContactDao) : DbRepository{
        return DbRepository(contactDao)
    }






}