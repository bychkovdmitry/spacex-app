package com.dbychkov.spacex.ui.next

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun NextLaunchScreen(
    viewModel: NextLaunchViewModel
) {
    val nextLaunch = viewModel.nextLaunch

    if (nextLaunch != null) {
        Text(text = nextLaunch.name)
    } else {
        Text(text = "Next launch")
    }
}
