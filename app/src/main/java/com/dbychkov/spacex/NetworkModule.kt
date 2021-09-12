package com.dbychkov.spacex

import com.dbychkov.spacex.api.LaunchesService
import com.dbychkov.spacex.api.RocketsService
import com.dbychkov.spacex.api.adapter.ZonedDateTimeAdapter
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class NetworkModule {

    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v4/")
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(ZonedDateTimeAdapter()).build()
                )
            )
            .validateEagerly(BuildConfig.DEBUG)
            .build()
    }

    fun launchesService(retrofit: Retrofit): LaunchesService = retrofit.createService()

    fun rocketsService(retrofit: Retrofit): RocketsService = retrofit.createService()

    private inline fun <reified T> Retrofit.createService(): T {
        return create((T::class.java))
    }
}