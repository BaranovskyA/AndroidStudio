package com.example.education.presentation.fragments

import android.support.v4.app.Fragment
import android.view.View

abstract class BaseFragment : Fragment() {
    var rootView : View? = null

    open fun initializeData() { }
}