package com.example.mvpkotlin.ui.detail

import com.example.mvpkotlin.data.Repo
import com.example.mvpkotlin.ui.IViews

interface DetailViews:IViews{
    fun showRepo(repos:List<Repo>)
}