package com.wultimaproject.shinny2019.common.dependencyinjection.application

import com.wultimaproject.shinny2019.ui.ContactListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    internal abstract fun contribueContactListFragment(): ContactListFragment
}