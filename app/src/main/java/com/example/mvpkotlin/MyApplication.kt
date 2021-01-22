package com.example.mvpkotlin

import android.app.Application
import com.example.mvpkotlin.data.source.DataSourceModule

class MyApplication : Application() {

    private lateinit var appComponent: AppComponent

    companion object {
        private lateinit var app: MyApplication
        fun getApplication(): MyApplication {
            return app
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        appComponent = DaggerAppComponent.builder().dataSourceModule(DataSourceModule()).build()
    }

    fun getAppComponent():AppComponent = appComponent
}