package com.example.mvpkotlin.data.source

import com.example.mvpkotlin.data.Repo
import com.example.mvpkotlin.data.User
import rx.Observable

/**
 *  数据管理类
 */
class DataManager (val remote:IDataSource,val local:IDataSource){

    fun getUsers(key:String): Observable<List<User>> {
        return remote.getUsers(key).onErrorResumeNext(local.getUsers(key))
            .map { it.items }
    }

    fun getRepos(path:String):Observable<List<Repo>> = remote.getRepos(path).onErrorResumeNext(local.getRepos(path))

}