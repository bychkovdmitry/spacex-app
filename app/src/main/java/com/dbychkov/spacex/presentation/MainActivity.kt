package com.dbychkov.spacex.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dbychkov.spacex.presentation.launch_details.LaunchDetailsScreen
import com.dbychkov.spacex.presentation.launch_list.LaunchListScreen
import com.dbychkov.spacex.presentation.ui.theme.SpaceXAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.LaunchListScreen.route
                    ) {
                        composable(
                            route = Screen.LaunchListScreen.route
                        ) {
                            LaunchListScreen(navController)
                        }
                        composable(
                            route = Screen.LaunchDetailsScreen.route + "/{launchId}"
                        ) {
                            LaunchDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}
