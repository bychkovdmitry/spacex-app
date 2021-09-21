package com.dbychkov.spacex.presentation.next_launch

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dbychkov.spacex.domain.usecase.GetNextLaunchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NextLaunchViewModel @Inject constructor(
    private val getNextLaunchUseCase: GetNextLaunchUseCase
) : ViewModel() {

    var state: NextLaunchState by mutableStateOf(NextLaunchState())
        private set

    init {
        getNextLaunch()
    }

    private fun getNextLaunch() {
        viewModelScope.launch {
            state = NextLaunchState(isLoading = true)

            val result = getNextLaunchUseCase()
            state = if (result.isSuccess) {
                NextLaunchState(launch = result.getOrThrow())
            } else {
                NextLaunchState(error = result.exceptionOrNull())
            }
        }
    }
}
