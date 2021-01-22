package com.example.mvpkotlin.ui.detail

import com.example.mvpkotlin.data.source.DataManager
import com.example.mvpkotlin.ui.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class DetailActivityModule(val views: DetailActivity) {

    @ActivityScope
    @Provides
    fun provideAdapter(): DetailAdapter {
        return DetailAdapter(views)
    }

    @ActivityScope
    @Provides
    fun providePresenter(dataManager: DataManager): DetailPresenter {
        return DetailPresenter(views, dataManager)
    }
}