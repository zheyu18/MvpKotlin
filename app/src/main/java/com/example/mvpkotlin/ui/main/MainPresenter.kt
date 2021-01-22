package com.example.mvpkotlin.ui.main

import com.example.mvpkotlin.data.source.DataManager
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainPresenter (val views:MainViews,val dataManager: DataManager){
    fun getUsers(key:String){
        dataManager.getUsers(key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { views.startLoading() }
            .doOnEach { views.stopLoading() }
            .subscribe { views.showUsers(it) }
    }
}