package com.dbychkov.spacex.domain.repository

import com.dbychkov.spacex.domain.model.Launch

interface LaunchRepository {

    suspend fun getAllLaunches(): List<Launch>

    suspend fun getNextLaunch(): Launch

    suspend fun getLaunchById(id: String): Launch
}
