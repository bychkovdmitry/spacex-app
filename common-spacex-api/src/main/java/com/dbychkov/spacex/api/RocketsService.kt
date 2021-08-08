package com.dbychkov.spacex.api

import com.dbychkov.spacex.api.model.dto.RocketDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RocketsService {

    @GET("rockets")
    suspend fun getAllRockets(): List<RocketDto>

    @GET("rockets/{rocketId}")
    suspend fun getRocket(@Path("rocketId") rocketId: String): RocketDto
}