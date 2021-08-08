package com.dbychkov.spacex.api

import retrofit2.http.GET

import com.dbychkov.spacex.api.model.dto.LaunchDto
import retrofit2.http.Path

interface LaunchesService {

    @GET("launches")
    suspend fun getAllLaunches(): List<LaunchDto>

    @GET("launches/past")
    suspend fun getPastLaunches(): List<LaunchDto>

    @GET("launches/upcoming")
    suspend fun getUpcomingLaunches(): List<LaunchDto>

    @GET("launches/{id}")
    suspend fun getLaunch(@Path("id") id: String): LaunchDto

    @GET("launches/latest")
    suspend fun getLatestLaunches(): LaunchDto

    @GET("launches/next")
    suspend fun getNextLaunches(): LaunchDto
}