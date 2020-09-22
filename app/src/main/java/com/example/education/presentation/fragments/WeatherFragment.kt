package com.example.education.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.education.R
import com.example.education.data.City
import com.example.education.presentation.activity.BaseActivity
import com.example.education.presentation.adapter.WeatherAdapter
import kotlinx.android.synthetic.main.fragment_cities.*

class WeatherFragment(city: City, private val activity: BaseActivity) : BaseFragment() {
    var weather: City = city
    var adapter : WeatherAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_cities, container, false)
        return rootView
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeAdapter()
        initializeRecyclerView()
        initializeLayoutManager()
    }

    fun updateAdapter() {
        adapter!!.notifyDataSetChanged()
    }

    fun initializeAdapter(){
        adapter = WeatherAdapter(weather, activity)
    }

    private fun initializeLayoutManager(){
        recyclerview_fragment_cities?.layoutManager = LinearLayoutManager(context)
    }

    private fun initializeRecyclerView(){
        recyclerview_fragment_cities?.adapter = adapter
    }
}