package com.example.weighttrackingapp.ui

import android.app.Application
import com.orhanobut.hawk.Hawk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application(){

    override fun onCreate() {
        super.onCreate()
        setupHawk()
    }

    private fun setupHawk(){
        Hawk.init(this).build()
    }
}