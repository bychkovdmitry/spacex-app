package com.dbychkov.spacex

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dbychkov.spacex.api.model.dto.LaunchDto

@Composable
fun LaunchItem(
    launchDto: LaunchDto,
    onLaunchClick: (LaunchDto) -> Unit
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
                text = launchDto.name,
            )
        }
    }
}