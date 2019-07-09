package com.wultimaproject.shinny2019

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wultimaproject.shinny2019.common.dependencyinjection.application.ApplicationComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ShinnyApplication.component.inject(this)
        setContentView(R.layout.activity_main)
    }
}
