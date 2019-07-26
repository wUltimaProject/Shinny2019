package com.wultimaproject.shinny2019.common.dependencyinjection.application

import com.wultimaproject.shinny2019.MainActivity
import com.wultimaproject.shinny2019.ui.ContactListFragment
import com.wultimaproject.shinny2019.repositories.DbRepository

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class] )

    interface ApplicationComponent {
        fun inject(mainActivity: MainActivity)
        fun inject(dbRepository: DbRepository)
        fun inject(contactListFragment: ContactListFragment)

    }
