package com.dbychkov.spacex.presentation.next_launch

import com.dbychkov.spacex.domain.model.Launch

data class NextLaunchState(
    val isLoading: Boolean = false,
    val launch: Launch? = null,
    val error: Throwable? = null
)
