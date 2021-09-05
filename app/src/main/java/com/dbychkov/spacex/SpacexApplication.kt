package com.dbychkov.spacex

import android.app.Application

class SpacexApplication : Application() {

    private val networkModule = NetworkModule()

    val launchesService = networkModule.launchesService(networkModule.retrofit())

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: SpacexApplication
            private set
    }
}