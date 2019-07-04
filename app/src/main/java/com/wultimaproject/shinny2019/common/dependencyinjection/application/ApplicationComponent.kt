package com.wultimaproject.shinny2019.common.dependencyinjection.application

import com.wultimaproject.shinny2019.ShinnyApplication
import com.wultimaproject.shinny2019.common.dependencyinjection.application.ApplicationModule
import dagger.Component
import javax.inject.Singleton


    @Singleton
    @Component(modules = arrayOf(ApplicationModule::class))
    interface ApplicationComponent {
        fun inject(application: ShinnyApplication)
    }
