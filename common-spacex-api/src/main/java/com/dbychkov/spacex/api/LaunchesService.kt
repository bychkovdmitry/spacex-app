package com.dbychkov.spacex.api

import com.dbychkov.spacex.api.model.Launch
import retrofit2.http.GET
import retrofit2.http.Path

interface LaunchesService {

    @GET("launches")
    suspend fun getAllLaunches(): List<Launch>

    @GET("launches/past")
    suspend fun getPastLaunches(): List<Launch>

    @GET("launches/upcoming")
    suspend fun getUpcomingLaunches(): List<Launch>

    @GET("launches/{id}")
    suspend fun getLaunch(@Path("id") id: String): Launch

    @GET("launches/latest")
    suspend fun getLatestLaunches(): Launch

    @GET("launches/next")
    suspend fun getNextLaunch(): Launch
}
