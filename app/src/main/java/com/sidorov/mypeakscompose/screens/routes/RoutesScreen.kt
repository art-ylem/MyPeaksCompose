package com.sidorov.mypeakscompose.screens.routes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sidorov.mypeakscompose.navigation.Router

@Composable
fun RoutesScreen(
    router: Router?,
    navController: NavController,
    viewModel: RouteViewModel = hiltViewModel()
) {

    val viewState = viewModel.getUiStateLiveData().observeAsState()

    when (val state = viewState.value) {
        RouteViewModel.ViewState.LoadingViewState -> {
            routesViewLoading()
        }
        is RouteViewModel.ViewState.OnSuccessState -> {
            LazyColumn(
                Modifier.fillMaxSize()
            ) {
                state.onSuccessData.routes.forEach {
                    item {
                        RouteItem(it)
                    }
                }
            }
        }
    }
}
