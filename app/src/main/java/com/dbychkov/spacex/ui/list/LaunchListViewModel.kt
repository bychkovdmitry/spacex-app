package com.dbychkov.spacex.ui.list

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
class LaunchListViewModel @Inject constructor(
    private val launchesService: LaunchesService
) : ViewModel() {

    var launches: List<Launch> by mutableStateOf(listOf())
        private set

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                launches = launchesService.getAllLaunches()
            }
        }
    }
}
