package com.example.mvpkotlin.ui.main

import com.example.mvpkotlin.AppComponent
import com.example.mvpkotlin.ui.ActivityScope
import dagger.Component

@ActivityScope
@Component(modules = arrayOf(MainActivityModule::class),dependencies = arrayOf(AppComponent::class))
interface MainActivityComponent{
    fun inject(activity:MainActivity)
}