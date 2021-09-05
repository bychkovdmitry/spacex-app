package com.dbychkov.spacex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.dbychkov.spacex.ui.theme.SpaceXAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dbychkov.spacex.viewmodel.LaunchesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Launches()
                }
            }
        }
    }
}

@Composable
fun Launches(
    viewModel: LaunchesViewModel = viewModel()
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(viewModel.launches) { index, item ->
            LaunchItem(launchDto = item, onLaunchClick = {})
        }
    }
}