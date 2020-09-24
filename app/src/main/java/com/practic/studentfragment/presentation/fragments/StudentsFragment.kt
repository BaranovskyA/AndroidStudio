package com.practic.studentfragment.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.practic.studentfragment.R
import com.practic.studentfragment.domain.Student
import com.practic.studentfragment.presentation.adapter.StudentsAdapter
import com.practic.studentfragment.presentation.base.BaseFragment
import com.practic.studentfragment.presentation.contracts.StudentsFragmentContract
import com.practic.studentfragment.presentation.interfaces.IStudentAdapterCallback
import com.practic.studentfragment.presentation.presenters.StudentsFragmentPresenter
import kotlinx.android.synthetic.main.fragment_students.*


class StudentsFragment : IStudentAdapterCallback, BaseFragment(),
    StudentsFragmentContract.View {

    var students: ArrayList<Student> = ArrayList()

    var studentsAdapter: StudentsAdapter? = null

    lateinit var presenter: StudentsFragmentPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle: Bundle? = this.arguments
        val student: Student? = bundle?.getParcelable("studentFromLoginFragment")

        initializeViews()
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter(this)
        initializeRecyclerView()

        presenter.initializeData()
        student?.let { students.add(it) }
    }


    override fun initializeLayout(): Int {
        return R.layout.fragment_students
    }

    override fun initializePresenter() {
        presenter = StudentsFragmentPresenter()
        presenter.attach(this, context)
    }

    override fun initializeLayoutManager() {
        recyclerview_fragment_students?.layoutManager = LinearLayoutManager(context)
    }

    override fun initializeAdapter(callback: IStudentAdapterCallback) {
        studentsAdapter = StudentsAdapter(students, callback)
    }

    override fun initiateUpdateAdapter() {
        studentsAdapter?.notifyDataSetChanged()
    }

    override fun initializeRecyclerView() {
        recyclerview_fragment_students?.adapter = studentsAdapter
    }

    override fun initializeUpdateData(students: ArrayList<Student>) {
        this.students.clear()
        this.students.addAll(students)
    }

    override fun initiateDetailTransition() {

    }

    override fun initializeViews() {
        recyclerview_fragment_students?.visibility = View.VISIBLE
    }

    override fun onMethodCallback(student: Student) {
        var fragment: StudentDetailFragment = StudentDetailFragment()
        var bundle: Bundle = Bundle()
        bundle.putParcelable("studentFromStudentFragment", student)
        fragment.arguments = bundle

        fragmentManager?.beginTransaction()?.add(
            R.id.framelayout_activity_main_fragment_container,
            fragment
        )?.hide(this)?.addToBackStack("studentDetail")?.commit()
    }


}