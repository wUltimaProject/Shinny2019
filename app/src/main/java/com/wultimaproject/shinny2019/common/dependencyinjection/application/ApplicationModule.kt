package com.wultimaproject.shinny2019.common.dependencyinjection.application

import android.app.Application
import com.wultimaproject.shinny2019.ShinnyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: ShinnyApplication) {

    @Provides
    @Singleton
    fun provideApplication() = baseApp

}