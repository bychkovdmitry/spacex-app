package com.dbychkov.spacex.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dbychkov.spacex.SpacexApplication
import com.dbychkov.spacex.api.model.dto.LaunchDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LaunchesViewModel : ViewModel() {

    var launches: List<LaunchDto> by mutableStateOf(listOf())
        private set

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                launches = SpacexApplication.instance.launchesService.getAllLaunches()
            }
        }
    }
}
