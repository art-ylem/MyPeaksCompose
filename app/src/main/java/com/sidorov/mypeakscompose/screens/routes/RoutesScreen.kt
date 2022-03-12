package com.sidorov.mypeakscompose.screens.routes

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sidorov.mypeakscompose.navigation.Router
import com.sidorov.mypeakscompose.screens.MainScreenViewModel

@OptIn(
    ExperimentalAnimationApi::class, androidx.compose.ui.ExperimentalComposeUiApi::class,
    androidx.compose.material.ExperimentalMaterialApi::class
)
@Composable
fun RoutesScreen(
    router: Router?,
    navController: NavController,
    mainScreenViewModel: MainScreenViewModel,
    viewModel: RouteViewModel = hiltViewModel()
) {

    val viewState = viewModel.uiStateLiveData().observeAsState()

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
                        RouteItem(it, mainScreenViewModel, navController)
                    }
                }
            }
        }
        RouteViewModel.ViewState.ErrorViewState -> {}
        null -> {}
    }
}
