package com.dbychkov.spacex.data.remote

import com.dbychkov.spacex.data.remote.dto.LaunchDto
import retrofit2.http.GET
import retrofit2.http.Path

interface LaunchApi {

    @GET("launches")
    suspend fun getAllLaunches(): List<LaunchDto>

    @GET("launches/{id}")
    suspend fun getLaunchById(@Path("id") id: String): LaunchDto

    @GET("launches/next")
    suspend fun getNextLaunch(): LaunchDto
}
