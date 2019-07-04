package com.wultimaproject.shinny2019.common.dependencyinjection.application

import com.wultimaproject.shinny2019.ShinnyApplication
import com.wultimaproject.shinny2019.ui.viewmodels.ContactListVM

import dagger.Component
import javax.inject.Singleton


    @Singleton
    @Component(modules = arrayOf(ApplicationModule::class, DatabaseModule::class) )
    interface ApplicationComponent {
        fun inject(application: ShinnyApplication)
        fun inject(contactListVm: ContactListVM)
    }
