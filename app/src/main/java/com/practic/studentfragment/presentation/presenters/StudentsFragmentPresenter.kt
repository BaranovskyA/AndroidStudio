package com.practic.studentfragment.presentation.presenters

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import com.practic.studentfragment.R
import com.practic.studentfragment.domain.CurrencyObject
import com.practic.studentfragment.domain.Student
import com.practic.studentfragment.domain.usecase.GetCurrenciesUseCase
import com.practic.studentfragment.presentation.contracts.StudentsFragmentContract
import io.reactivex.observers.DisposableObserver

class StudentsFragmentPresenter : StudentsFragmentContract.Presenter {

    var view: StudentsFragmentContract.View? = null
    var students: ArrayList<Student> = ArrayList()
    var context: Context? = null
    var getCurrenciesUseCase: GetCurrenciesUseCase = GetCurrenciesUseCase()

    override fun attach(view: StudentsFragmentContract.View, context: Context?) {
        this.view = view
        this.context = context
    }

    override fun initializeData() {
        view?.initializeUpdateData(students.apply {
            add(
                Student(
                    "Ruslan",
                    "Good Student",
                    BitmapFactory.decodeResource(context?.resources, R.drawable.ic_launcher)
                )
            )
            add(
                Student(
                    "Artur",
                    "Bad Student",
                    BitmapFactory.decodeResource(context?.resources, R.drawable.ic_launcher)
                )
            )
            add(
                Student(
                    "Alex",
                    "Average Student",
                    BitmapFactory.decodeResource(context?.resources, R.drawable.ic_launcher)
                )
            )
        })
        view?.initiateUpdateAdapter()
    }

    override fun initiateRequestCurrencies() {
        getCurrenciesUseCase.execute(CurrenciesObserver())
    }

    class CurrenciesObserver : DisposableObserver<CurrencyObject>() {
        override fun onComplete() {
            Log.d("DATA", "onComplete")
        }

        override fun onNext(t: CurrencyObject) {
            Log.d("DATA", "onNext")
        }

        override fun onError(e: Throwable) {
            Log.d("DATA", "onError")
        }

    }


}