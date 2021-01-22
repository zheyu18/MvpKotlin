package com.example.mvpkotlin

import com.example.mvpkotlin.data.source.DataManager
import com.example.mvpkotlin.data.source.DataSourceModule
import dagger.Component
import javax.inject.Singleton

/**
 *
//对象获取
person.javaClass// javaClass
person::class.java // javaClass
//类获取
Person::class// kClass
person.javaClass.kotlin// kClass
(Person::class as Any).javaClass// javaClass
Person::class.java // javaClass
 */
@Singleton  // 数组的读写
@Component(modules = arrayOf(DataSourceModule::class))
interface AppComponent {
    /**
     *  全局注入器能够提供的对象
     */
    fun dataManager():DataManager
}