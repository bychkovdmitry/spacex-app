package com.dbychkov.spacex.presentation.launch_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dbychkov.spacex.domain.usecase.GetAllLaunchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchListViewModel @Inject constructor(
    private val getAllLaunchesUseCase: GetAllLaunchesUseCase
) : ViewModel() {

    var state: LaunchListState by mutableStateOf(LaunchListState())
        private set

    init {
        getLaunches()
    }

    private fun getLaunches() {
        viewModelScope.launch {
            state = LaunchListState(isLoading = true)

            val result = getAllLaunchesUseCase()
            state = if (result.isSuccess) {
                LaunchListState(launches = result.getOrThrow())
            } else {
                LaunchListState(error = result.exceptionOrNull())
            }
        }
    }
}
