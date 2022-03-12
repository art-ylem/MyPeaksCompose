package com.sidorov.mypeakscompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.sidorov.mypeakscompose.screens.MainScreenViewModel
import com.sidorov.mypeakscompose.screens.routes.RoutesDetailsScreen
import com.sidorov.mypeakscompose.screens.routes.RoutesScreen

@ExperimentalAnimationApi
@Composable
fun RoutesContainer(
    externalRouter: Router,
    mainScreenViewModel: MainScreenViewModel
) {
    NavigationController(
        startDestination = Screen.Routes.screenName,
        router = externalRouter,
        screens = listOf(
            Pair(Screen.Routes.screenName) { nav, router, _ -> RoutesScreen(router, nav, mainScreenViewModel) },
            Pair(Screen.RouteDetails.screenName) { nav, _, params ->
                RoutesDetailsScreen(nav)
            }
        )
    )
}
