package com.example.mvpkotlin.ui.detail

import com.example.mvpkotlin.AppComponent
import com.example.mvpkotlin.ui.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(DetailActivityModule::class))
interface DetailActivityComponent {
    fun inject(activity: DetailActivity)
}