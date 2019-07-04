package com.wultimaproject.shinny2019.common.dependencyinjection.presentation

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager


import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private val mActivity: FragmentActivity) {

    internal val fragmentManager: FragmentManager
        @Provides
        get() = mActivity.getSupportFragmentManager()

    internal val layoutInflater: LayoutInflater
        @Provides
        get() = LayoutInflater.from(mActivity)

    internal val activity: Activity
        @Provides
        get() = mActivity

    @Provides
    internal fun context(activity: Activity): Context {
        return activity
    }

//    @Provides
//    internal fun getFetchQuestionDetailsUseCase(stackoverflowApi: StackoverflowApi): FetchQuestionDetailsUseCase {
//        return FetchQuestionDetailsUseCase(stackoverflowApi)
//    }
//
//    @Provides
//    internal fun getDialogsManager(fragmentManager: FragmentManager): DialogsManager {
//        return DialogsManager(fragmentManager)
//    }
//
//    @Provides
//    internal fun getImageLoader(activity: Activity): ImageLoader {
//        return ImageLoader(activity)
//    }
}
