package com.example.mvpkotlin.api

import com.example.mvpkotlin.data.Repo
import com.example.mvpkotlin.data.Users
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import rx.Observable

interface GithubService {

    @GET("search/users")
    fun getUsers(@Query("q") key: String): Observable<Users>

    @GET
    fun getRepos(@Url path: String):Observable<List<Repo>>

}