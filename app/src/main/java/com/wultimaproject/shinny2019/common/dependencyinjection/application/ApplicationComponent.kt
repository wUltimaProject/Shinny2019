package com.wultimaproject.shinny2019.common.dependencyinjection.application

import android.app.Application
import com.wultimaproject.shinny2019.MainActivity
import com.wultimaproject.shinny2019.ShinnyApplication
import com.wultimaproject.shinny2019.model.db.ContactDao
import com.wultimaproject.shinny2019.model.db.ShinnyDatabase
import com.wultimaproject.shinny2019.ui.ContactListFragment
import com.wultimaproject.shinny2019.ui.repositories.DbRepository
import com.wultimaproject.shinny2019.ui.viewmodels.ContactListVM
import dagger.BindsInstance

import dagger.Component
import javax.inject.Singleton
import dagger.Binds

@Singleton
@Component(modules = [ApplicationModule::class] )

    interface ApplicationComponent {
        fun inject(mainActivity: MainActivity)
        fun inject(dbRepository: DbRepository)
       fun inject(contactListFragment: ContactListFragment)
    }
