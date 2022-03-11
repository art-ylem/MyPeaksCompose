package com.sidorov.mypeakscompose

import io.reactivex.disposables.CompositeDisposable

abstract class BaseUseCase {

    protected open val subscriptions = CompositeDisposable()

    open fun clear() {
        subscriptions.clear()
    }
}
