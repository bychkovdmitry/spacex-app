package com.dbychkov.spacex.ui.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dbychkov.spacex.api.model.Launch

@Composable
fun LunchListScreen(
    viewModel: LaunchListViewModel
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(viewModel.launches) { index, item ->
            LaunchItem(launch = item, onLaunchClick = {})
        }
    }
}

@Composable
fun LaunchItem(
    launch: Launch,
    onLaunchClick: (Launch) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
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
