package com.dbychkov.spacex.presentation.launch_details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dbychkov.spacex.domain.usecase.GetLaunchByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchDetailsViewModel @Inject constructor(
    private val getLaunchByIdUseCase: GetLaunchByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state: LaunchDetailsState by mutableStateOf(LaunchDetailsState())
        private set

    init {
        savedStateHandle.get<String>("launchId")?.let { launchId ->
            getLaunch(launchId)
        }
    }

    private fun getLaunch(launchId: String) {
        viewModelScope.launch {
            state = LaunchDetailsState(isLoading = true)

            val result = getLaunchByIdUseCase(launchId)
            state = if (result.isSuccess) {
                LaunchDetailsState(launch = result.getOrThrow())
            } else {
                LaunchDetailsState(error = result.exceptionOrNull())
            }
        }
    }
}
