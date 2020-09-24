package com.practic.studentfragment.presentation.contracts

import com.practic.studentfragment.data.StudentEntity
import com.practic.studentfragment.domain.Student
import com.practic.studentfragment.presentation.base.BaseContract
import com.practic.studentfragment.presentation.interfaces.IStudentAdapterCallback

interface StudentsFragmentContract {

    interface View : BaseContract.BaseView{
        fun initializePresenter()

        fun initializeLayoutManager()

        fun initializeAdapter(callback: IStudentAdapterCallback)

        fun initiateUpdateAdapter()

        fun initializeRecyclerView()

        fun initializeUpdateData(students: ArrayList<Student>)

        fun initiateDetailTransition()
    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData()

        fun initiateRequestCurrencies()

//        fun initiateSortStudentsByName()
//
//        fun initiateRequestCurrencies()
//
//        fun initiateSortStudentsRandom()
    }
}