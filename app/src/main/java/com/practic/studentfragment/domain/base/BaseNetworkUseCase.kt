package com.practic.studentfragment.domain.base

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class BaseNetworkUseCase<T> {

    var compositeDisposable = CompositeDisposable()

    fun execute(disposableObserver: DisposableObserver<T>){
        var observable = this.initiateCreateObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        var observer = observable.subscribeWith(disposableObserver)

        compositeDisposable.add(observer)
    }

    fun clear(){
        compositeDisposable.clear()
    }

    abstract fun initiateCreateObservable() : Observable<T>
}