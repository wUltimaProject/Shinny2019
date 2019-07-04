package com.wultimaproject.shinny2019

import android.app.Application
import com.wultimaproject.shinny2019.common.dependencyinjection.application.ApplicationComponent
import com.wultimaproject.shinny2019.common.dependencyinjection.application.ApplicationModule
import com.wultimaproject.shinny2019.common.dependencyinjection.application.DaggerApplicationComponent

class ShinnyApplication : Application(){



    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }


}