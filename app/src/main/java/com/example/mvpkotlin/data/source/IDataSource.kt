package com.example.mvpkotlin.data.source

import com.example.mvpkotlin.data.Repo
import com.example.mvpkotlin.data.Users
import rx.Observable


/**
 *  数据源接口
 */
interface IDataSource {

    fun getUsers(key: String): Observable<Users>

    fun getRepos(path:String):Observable<List<Repo>>

}