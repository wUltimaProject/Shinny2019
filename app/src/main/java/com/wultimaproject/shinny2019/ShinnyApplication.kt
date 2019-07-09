package com.wultimaproject.shinny2019

import android.app.Application
import com.wultimaproject.shinny2019.common.dependencyinjection.application.ApplicationComponent
import com.wultimaproject.shinny2019.common.dependencyinjection.application.ApplicationModule
import com.wultimaproject.shinny2019.common.dependencyinjection.application.DaggerApplicationComponent

open class ShinnyApplication : Application(){

    companion object {
        lateinit var component: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
//        val component: ApplicationComponent by lazy {
//            DaggerApplicationComponent.builder()
//                .applicationModule(ApplicationModule(this))
//                .build()
//        }
    }


    fun getAppComponent(): ApplicationComponent{
        return component
    }


}