package com.practic.studentfragment.presentation.base

import android.content.Context

interface BaseContract {
    interface BaseView {
        fun initializeViews()
    }

    interface BasePresenter<T> {
        fun attach(view: T, context: Context?)
    }
}