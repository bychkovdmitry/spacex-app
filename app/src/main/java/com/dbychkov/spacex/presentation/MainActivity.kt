package com.dbychkov.spacex.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import com.dbychkov.spacex.presentation.ui.theme.SpaceXAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen()
                }
            }
        }
    }
}