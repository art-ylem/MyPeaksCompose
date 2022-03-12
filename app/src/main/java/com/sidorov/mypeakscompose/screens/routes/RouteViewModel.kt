package com.sidorov.mypeakscompose.screens.routes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sidorov.mypeakscompose.BaseViewModel
import com.sidorov.mypeakscompose.data.vo.RoutesVO
import com.sidorov.mypeakscompose.domain.usecase.RoutesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RouteViewModel @Inject constructor(private val routesUseCase: RoutesUseCase) :
    BaseViewModel<RouteViewModel.ViewState>() {

    private var _uiStateLiveData: MutableLiveData<ViewState> = MutableLiveData()
    fun uiStateLiveData(): LiveData<ViewState> = _uiStateLiveData

    init {
        addUseCase()
        loadData()
        _uiStateLiveData.postState(ViewState.LoadingViewState)
    }

    private fun loadData() {
        val dis = routesUseCase.getRoutes().subscribe({
            _uiStateLiveData.postState(ViewState.OnSuccessState(it))
        }, {
            _uiStateLiveData.postState(ViewState.ErrorViewState)
        })
        cd.add(dis)
    }

    sealed class ViewState {
        object LoadingViewState : ViewState()
        object ErrorViewState : ViewState()
        class OnSuccessState(val onSuccessData: RoutesVO) : ViewState()
    }
}
