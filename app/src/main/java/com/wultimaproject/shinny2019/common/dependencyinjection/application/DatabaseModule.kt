package com.wultimaproject.shinny2019.common.dependencyinjection.application

import android.app.Application
import androidx.room.Room
import com.wultimaproject.shinny2019.model.db.ContactDao
import com.wultimaproject.shinny2019.model.db.ShinnyDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule{

    @Provides
    @Singleton
    internal fun provideDatabase(application: Application): ShinnyDatabase {
        return Room.databaseBuilder(
            application, ShinnyDatabase::class.java, "Entertainment.db")
            .allowMainThreadQueries().build()
    }


    /*
     * We need the MovieDao module.
     * For this, We need the AppDatabase object
     * So we will define the providers for this here in this module.
     * */
    @Provides
    @Singleton
    internal fun provideContactDao(appDatabase: ShinnyDatabase): ContactDao {
        return appDatabase.contactDao()
    }

}