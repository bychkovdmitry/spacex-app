package com.dbychkov.spacex.domain.usecase

import com.dbychkov.spacex.domain.model.Launch
import com.dbychkov.spacex.domain.repository.LaunchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetNextLaunchUseCase @Inject constructor(
    private val repository: LaunchRepository
) {
    suspend operator fun invoke(): Result<Launch> {
        return withContext(Dispatchers.IO) {
            try {
                Result.success(repository.getNextLaunch())
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}
