package com.dbychkov.spacex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
//import com.dbychkov.spacex.api.model.dto.LaunchDto
import com.dbychkov.spacex.ui.theme.SpaceXAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }

        val networkModule = NetworkModule()
        val launchesService = networkModule.launchesService(networkModule.retrofit())
        val rocketsService = networkModule.rocketsService(networkModule.retrofit())

        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val result = launchesService.getAllLaunches()
                println(result)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpaceXAppTheme {
        Greeting("Android")
    }
}