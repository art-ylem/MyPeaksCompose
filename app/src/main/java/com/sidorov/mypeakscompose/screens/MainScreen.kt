package com.sidorov.mypeakscompose.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sidorov.mypeakscompose.navigation.Router
import com.sidorov.mypeakscompose.navigation.RoutesContainer
import com.sidorov.mypeakscompose.navigation.Screen
import com.sidorov.mypeakscompose.screens.news.NewsScreen
import com.sidorov.mypeakscompose.screens.profile.ProfileScreen

@ExperimentalAnimationApi
@Composable
fun MainScreen(
    router: Router
) {
    // Stored in memory NavHostController
    // Live through recompose and configuration changed cycle by rememberSaving
    val navController = rememberNavController()
    val bottomItems = listOf(Screen.Routes, Screen.News, Screen.Profile)

    Column {
        Box(modifier = Modifier.weight(1f)) {
            NavHost(navController = navController, startDestination = Screen.Routes.screenName) {
                composable(Screen.Routes.screenName) { RoutesContainer(externalRouter = router) }
                composable(Screen.News.screenName) { NewsScreen(router) }
                composable(Screen.Profile.screenName) { ProfileScreen(router) }
            }
        }

        Box(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
        ) {
            BottomNavigation {
                bottomItems.forEach { screen ->
                    BottomNavigationItem(
                        selected = false,
                        onClick = {
                            navController.navigate(screen.screenName) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        },
                        label = { Text(stringResource(id = screen.titleResourceId)) },
                        icon = {
                        }
                    )
                }
            }
        }
    }
}
