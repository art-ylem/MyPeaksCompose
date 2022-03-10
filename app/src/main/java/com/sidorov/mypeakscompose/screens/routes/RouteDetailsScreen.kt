package com.sidorov.mypeakscompose.screens.routes

import androidx.compose.foundation.clickable
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun RoutesDetailsScreen(navController: NavController) {
    Scaffold() {
        Text(text = "Routes details", Modifier.clickable { navController.navigate("routes") })
    }
}
