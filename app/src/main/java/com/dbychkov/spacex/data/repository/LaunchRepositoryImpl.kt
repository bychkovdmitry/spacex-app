package com.dbychkov.spacex.data.repository

import com.dbychkov.spacex.data.remote.LaunchApi
import com.dbychkov.spacex.data.remote.dto.toModel
import com.dbychkov.spacex.domain.model.Launch
import com.dbychkov.spacex.domain.repository.LaunchRepository
import javax.inject.Inject

class LaunchRepositoryImpl @Inject constructor(
    private val launchApi: LaunchApi
) : LaunchRepository {

    override suspend fun getAllLaunches(): List<Launch> {
        return launchApi.getAllLaunches().map { it.toModel() }
    }

    override suspend fun getLaunchById(id: String): Launch {
        return launchApi.getLaunchById(id).toModel()
    }
}
