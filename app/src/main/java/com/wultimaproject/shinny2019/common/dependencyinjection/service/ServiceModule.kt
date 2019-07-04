package com.wultimaproject.shinny2019.common.dependencyinjection.service

import android.app.Service
import android.content.Context

import dagger.Module
import dagger.Provides

@Module
class ServiceModule(private val mService: Service) {

    @Provides
    internal fun service(): Service {
        return mService
    }

    @Provides
    internal fun context(service: Service): Context {
        return service
    }


}
