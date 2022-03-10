package com.sidorov.mypeakscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sidorov.mypeakscompose.screens.MainScreen
import com.sidorov.mypeakscompose.screens.empty.EmptyScreen
import com.sidorov.mypeakscompose.ui.theme.MyPeaksComposeTheme
import com.sidorov.mypeakscompose.utils.navigation.PresentModal
import com.sidorov.mypeakscompose.utils.navigation.Screen
import com.sidorov.mypeakscompose.utils.navigation.createExternalRouter
import com.sidorov.mypeakscompose.utils.navigation.navigate

class MainActivity : ComponentActivity() {

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPeaksComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Main.screenName
                    ) {
                        composable(Screen.Main.screenName) {
                            MainScreen(
                                createExternalRouter { screen, params ->
                                    navController.navigate(screen, params)
                                }
                            )
                        }

                        // something out of main screen container
                        composable(Screen.Error.screenName) {
                            PresentModal { EmptyScreen() }
                        }
                    }
                }
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
    MyPeaksComposeTheme {
        Greeting("Android")
    }
}
