package com.dbychkov.spacex.ui.next

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dbychkov.spacex.api.LaunchesService
import com.dbychkov.spacex.api.model.Launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NextLaunchViewModel @Inject constructor(
    private val launchesService: LaunchesService
) : ViewModel() {

    var nextLaunch: Launch? by mutableStateOf(null)
        private set

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                nextLaunch = launchesService.getNextLaunch()
            }
        }
    }
}
