package com.wultimaproject.shinny2019.common.dependencyinjection.application

import android.content.Context
import com.wultimaproject.shinny2019.ShinnyApplication
import com.wultimaproject.shinny2019.model.db.ContactDao
import com.wultimaproject.shinny2019.ui.repositories.DbRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: ShinnyApplication) {

    @Provides
    @Singleton
    fun provideApplication(): ShinnyApplication{
        return baseApp
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return baseApp
    }



    @Singleton
    @Provides
    fun productDbRepository(contactDao: ContactDao): DbRepository {
        return DbRepository(contactDao)
    }



}