package com.sidorov.mypeakscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sidorov.mypeakscompose.screens.news.NewsScreen
import com.sidorov.mypeakscompose.screens.profile.ProfileScreen
import com.sidorov.mypeakscompose.screens.routes.RoutesScreen
import com.sidorov.mypeakscompose.ui.theme.MyPeaksComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPeaksComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val bottomItems = listOf("Routes", "News", "Profile")
                    val navController = rememberNavController()

                    Scaffold(bottomBar = {
                        BottomNavigation {
                            bottomItems.forEach { screen ->
                                BottomNavigationItem(
                                    selected = false,
                                    onClick = { navController.navigate(screen) },
                                    label = { Text(text = screen) },
                                    icon = {}
                                )
                            }
                        }
                    }) {
                    }
                    NavHost(
                        navController = navController,
                        startDestination = bottomItems[0]
                    ) {
                        bottomItems.forEach { item ->
                            when (item) {
                                "Routes" -> composable(item) { RoutesScreen() }
                                "News" -> composable(item) { NewsScreen() }
                                "Profile" -> composable(item) { ProfileScreen() }
                            }
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
