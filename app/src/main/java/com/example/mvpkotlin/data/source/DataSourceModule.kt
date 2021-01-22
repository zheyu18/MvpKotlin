package com.example.mvpkotlin.data.source

import com.example.mvpkotlin.api.GithubService
import com.example.mvpkotlin.data.BASE_URL
import com.example.mvpkotlin.data.source.local.Local
import com.example.mvpkotlin.data.source.local.LocalDataSource
import com.example.mvpkotlin.data.source.remote.Remote
import com.example.mvpkotlin.data.source.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 *  对象工厂 提供依赖对象的注入方式
 */
@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideGitHubService(): GithubService {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .baseUrl(BASE_URL).build().create(GithubService::class.java)
    }

    @Singleton
    @Remote
    @Provides
    fun provideRemote(service: GithubService): IDataSource {
        return RemoteDataSource(service)
    }

    @Singleton
    @Local
    @Provides
    fun provideLocal(): IDataSource = LocalDataSource()

    /**
     *  提供DataManager
     */
    @Singleton
    @Provides
    fun providerDataManager(@Remote remote: IDataSource, @Local local: IDataSource): DataManager {
        return DataManager(remote, local)
    }


}