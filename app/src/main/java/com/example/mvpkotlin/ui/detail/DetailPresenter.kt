package com.example.mvpkotlin.ui.detail

import com.example.mvpkotlin.data.source.DataManager
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DetailPresenter (val views: DetailViews,val dataManager: DataManager){
    fun getRepos(path:String){
        dataManager.getRepos(path)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { views.startLoading() }
            .doOnEach { views.stopLoading() }
            .subscribe{
                views.showRepo(it)
            }

    }
}