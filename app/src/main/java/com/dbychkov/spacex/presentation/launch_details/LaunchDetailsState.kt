package com.dbychkov.spacex.presentation.launch_details

import com.dbychkov.spacex.domain.model.Launch

data class LaunchDetailsState(
    val isLoading: Boolean = false,
    val launch: Launch? = null,
    val error: Throwable? = null
)