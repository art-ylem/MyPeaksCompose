package com.sidorov.mypeakscompose

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel<T>() : ViewModel() {

    internal val cd = CompositeDisposable()

    private val useCases = mutableListOf<BaseUseCase>()

    fun addUseCase(vararg useCase: BaseUseCase) {
        useCases.addAll(useCase)
    }

    override fun onCleared() {
        useCases.forEach { it.clear() }
        super.onCleared()
    }

    fun MutableLiveData<T>.postState(state: T) {
        postValue(state)
    }
}
