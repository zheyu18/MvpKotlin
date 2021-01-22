package com.example.mvpkotlin.data.source.local

import com.example.mvpkotlin.data.Repo
import com.example.mvpkotlin.data.Users
import com.example.mvpkotlin.data.source.IDataSource
import rx.Observable

class LocalDataSource :IDataSource{
    override fun getRepos(path: String): Observable<List<Repo>> {
        return Observable.just(arrayListOf())
    }

    override fun getUsers(key: String): Observable<Users> {
        return Observable.just(Users(arrayListOf()))
    }


}