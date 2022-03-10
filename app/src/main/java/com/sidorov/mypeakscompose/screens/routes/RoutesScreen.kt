package com.sidorov.mypeakscompose.screens.routes

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.sidorov.mypeakscompose.utils.navigation.Router
import com.sidorov.mypeakscompose.utils.navigation.Screen

@Composable
fun RoutesScreen(router: Router?, navController: NavController) {
    Scaffold() {
        Column() {
            Text(text = "Routes")
            Button(onClick = { navController.navigate(Screen.RouteDetails.screenName) }) {
                Text(text = "Go to routes details page")
            }
        }
    }
}
