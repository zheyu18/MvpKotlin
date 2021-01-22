package com.example.mvpkotlin.ui.main

import com.example.mvpkotlin.data.source.DataManager
import com.example.mvpkotlin.ui.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(val view: MainActivity) {

    @ActivityScope
    @Provides
    fun providerPresenter(dataManager: DataManager):MainPresenter{
        return MainPresenter(view,dataManager)
    }

    @ActivityScope
    @Provides
    fun providerAdapter():MainAdapter{
        return MainAdapter(view)
    }

}