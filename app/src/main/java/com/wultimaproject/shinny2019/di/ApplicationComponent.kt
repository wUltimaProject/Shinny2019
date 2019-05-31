package com.wultimaproject.shinny2019.di

import com.wultimaproject.shinny2019.ShinnyApplication
import dagger.Component


class ApplicationComponent {
    @Component(modules = arrayOf(ApplicationModule::class))
    interface ApplicationComponent {

        fun inject(application: ShinnyApplication)

    }
}