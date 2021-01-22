package com.example.mvpkotlin.ui.main

import com.example.mvpkotlin.data.User
import com.example.mvpkotlin.ui.IViews

interface MainViews :IViews{
    fun showUsers(user: List<User>)
}