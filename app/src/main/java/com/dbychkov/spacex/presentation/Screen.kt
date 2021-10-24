package com.dbychkov.spacex.presentation

sealed class Screen(val route: String) {
    object LaunchListScreen : Screen("launch_list")
    object LaunchDetailsScreen : Screen("launch_details")
}
