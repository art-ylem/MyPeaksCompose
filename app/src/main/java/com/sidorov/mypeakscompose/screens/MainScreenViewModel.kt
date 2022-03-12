package com.sidorov.mypeakscompose.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sidorov.mypeakscompose.BaseViewModel

interface MainScreenViewModel {
    fun hideBottomNavBar()
    fun showBottomNavBar()
}

class MainScreenViewModelImpl() :
    BaseViewModel<MainScreenViewModelImpl.ViewState>(),
    MainScreenViewModel {

    private var _isBottomNavBarVisible: MutableLiveData<ViewState> = MutableLiveData()
    fun isBottomNavBarVisible(): LiveData<ViewState> = _isBottomNavBarVisible

    init {
        _isBottomNavBarVisible.postValue(ViewState.BottomNabBarVisibility(true))
    }

    override fun hideBottomNavBar() {
        _isBottomNavBarVisible.postValue(ViewState.BottomNabBarVisibility(false))
    }

    override fun showBottomNavBar() {
        _isBottomNavBarVisible.postValue(ViewState.BottomNabBarVisibility(true))
    }

    sealed class ViewState {
        class BottomNabBarVisibility(val isVisible: Boolean) : ViewState()
    }
}
