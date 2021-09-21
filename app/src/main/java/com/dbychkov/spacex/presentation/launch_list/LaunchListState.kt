package com.dbychkov.spacex.presentation.launch_list

import com.dbychkov.spacex.domain.model.Launch

data class LaunchListState(
    val isLoading: Boolean = false,
    val launches: List<Launch> = emptyList(),
    val error: Throwable? = null
)
