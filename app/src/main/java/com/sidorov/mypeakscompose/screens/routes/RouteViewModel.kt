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

    private var uiStateLiveData: MutableLiveData<ViewState> = MutableLiveData()
    fun getUiStateLiveData(): LiveData<ViewState> = uiStateLiveData
    fun setUiStateLiveData(ld: MutableLiveData<ViewState>) {
        uiStateLiveData = ld
    }

    init {
        addUseCase()
        loadData()
        uiStateLiveData.postState(ViewState.LoadingViewState)
    }

    private fun loadData() {
        val dis = routesUseCase.getRoutes().subscribe({
            uiStateLiveData.postState(ViewState.OnSuccessState(it))
        }, {
            val err = it
        })
        cd.add(dis)
    }

    sealed class ViewState {
        object LoadingViewState : ViewState()
        class OnSuccessState(val onSuccessData: RoutesVO) : ViewState()
    }
}
