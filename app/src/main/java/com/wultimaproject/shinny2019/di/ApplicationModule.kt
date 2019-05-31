package com.wultimaproject.shinny2019.di

import android.app.Application
import com.wultimaproject.shinny2019.ShinnyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: ShinnyApplication) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}