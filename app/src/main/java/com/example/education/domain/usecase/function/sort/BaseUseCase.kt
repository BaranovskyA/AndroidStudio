package com.example.education.domain.usecase.function.sort

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

abstract class BaseUseCase<T>(internal var executorThread: Scheduler, internal var uiThread: Scheduler) {
    internal var compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
    }

    fun execute(disposableObserver: DisposableObserver<T>) {
        val observable = this.createObservableObject()
            .subscribeOn(executorThread)
            .observeOn(uiThread)

        val observer = observable.subscribeWith(disposableObserver)
        compositeDisposable.add(observer)
    }

    fun clear() {
        compositeDisposable.clear()
    }

    fun dispose() {
        if (!compositeDisposable.isDisposed) compositeDisposable.dispose()
    }

    abstract fun createObservableObject(): Observable<T>
}