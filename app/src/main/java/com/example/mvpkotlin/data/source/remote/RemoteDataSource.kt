package com.example.mvpkotlin.data.source.remote

import com.example.mvpkotlin.api.GithubService
import com.example.mvpkotlin.data.Repo
import com.example.mvpkotlin.data.Users
import com.example.mvpkotlin.data.source.IDataSource
import rx.Observable

class RemoteDataSource(val service: GithubService) : IDataSource {

    override fun getRepos(path: String): Observable<List<Repo>> = service.getRepos(path)

    override fun getUsers(path: String): Observable<Users> = service.getUsers(path)


}