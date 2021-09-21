package com.dbychkov.spacex.presentation.launch_list

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dbychkov.spacex.domain.model.Launch

@Composable
fun LaunchListItem(
    launch: Launch,
    onItemClick: (Launch) -> Unit
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
