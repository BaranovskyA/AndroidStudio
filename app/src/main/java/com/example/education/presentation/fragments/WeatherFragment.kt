package com.example.education.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.education.R
import com.example.education.data.Weather
import com.example.education.presentation.adapter.WeatherAdapter
import kotlinx.android.synthetic.main.fragment_cities.*

class WeatherFragment  : BaseFragment() {
    var weathers: ArrayList<Weather> = ArrayList()
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

        initializeData()
        initializeAdapter()
        initializeRecyclerView()
        initializeLayoutManager()
    }

    fun sortCitiesByName() {

        updateAdapter()
    }

    fun updateAdapter() {
        adapter!!.notifyDataSetChanged()
    }

    fun initializeAdapter(){
        adapter = WeatherAdapter(CityFragment().initializeData())
    }

    fun initializeData(): ArrayList<Weather> {
        if(weathers.size == 0) {
            weathers.add( Weather().apply { situation = "Cloudy"; temperature = 30.0; pressure = 1000; humidity = 81;
            windSpeed = 4.6; small_day_first = "SAT"; small_temperature_first = 30.0; small_day_second = "SUN"; small_temperature_second = 30.0;
            small_day_third = "MON"; small_temperature_third = 29.0; small_day_fourth = "TUE"; small_temperature_fourth = 29.0;
            small_day_fifth = "WED"; small_temperature_fifth = 30.0;} )
        }
        return weathers
    }

    private fun initializeLayoutManager(){
        recyclerview_fragment_cities?.layoutManager = LinearLayoutManager(context)
    }

    private fun initializeRecyclerView(){
        recyclerview_fragment_cities?.adapter = adapter
    }
}