package com.dbychkov.spacex.presentation.launch_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dbychkov.spacex.domain.model.Launch
import com.dbychkov.spacex.presentation.Screen

@Composable
fun LaunchListScreen(
    navController: NavController,
    viewModel: LaunchListViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.launches) { launch ->
                LaunchListItem(
                    launch = launch,
                    onItemClick = {
                        navController.navigate(Screen.LaunchDetailsScreen.route + "/${launch.id}")
                    }
                )
            }
        }

        if (state.error != null) {
            Text(
                text = state.error.message ?: "",
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun LaunchListItem(
    launch: Launch,
    onItemClick: (Launch) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
            .clickable { onItemClick(launch) }
            .wrapContentHeight()
    ) {
        Box(
            Modifier
                .padding(start = 8.dp)
        ) {
            Text(
                text = launch.name,
            )
        }
    }
}
