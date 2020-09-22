package com.example.education.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.education.R
import com.example.education.data.City
import com.example.education.data.Weather
import com.example.education.domain.usecase.function.sort.WeatherResult
import com.example.education.domain.usecase.function.sort.RequestCurrentWeatherUseCase
import com.example.education.presentation.activity.BaseActivity
import com.example.education.presentation.adapter.CityAdapter
import com.example.education.presentation.dialog.CustomDialogFragment
import io.reactivex.observers.DisposableObserver
import kotlinx.android.synthetic.main.fragment_cities.*

class CityFragment(private val activity: BaseActivity) : BaseFragment() {
    var cities: ArrayList<City> = ArrayList()
    var adapter : CityAdapter? = null

    lateinit var currentWeatherUseCase: RequestCurrentWeatherUseCase

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_cities, container, false)

        val currenctWeatherObserver: CurrentWeatherObserver = CurrentWeatherObserver()

        currentWeatherUseCase = RequestCurrentWeatherUseCase()
        currentWeatherUseCase.execute(currenctWeatherObserver)
        currentWeatherUseCase.dispose()
        return rootView
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initializeData()
        initializeAdapter()
        initializeRecyclerView()
        initializeLayoutManager()

        initializeOnClickListener()
    }

    override fun onStop() {
        super.onStop()
        currentWeatherUseCase.clear()
    }

    class CurrentWeatherObserver : DisposableObserver<WeatherResult>() {
        override fun onComplete() {
        }

        override fun onNext(t: WeatherResult) {
            Log.d("HERE", t.toString())
        }

        override fun onError(e: Throwable) {
        }

    }

    fun initializeOnClickListener() {
        button_fragment_cities_add_location.setOnClickListener {
            val dialog =
                CustomDialogFragment()
            dialog.onOk = {
                addCity(dialog.editText.text.toString())
                button_fragment_cities_add_location.visibility = View.INVISIBLE
            }
            dialog.show(activity.supportFragmentManager, "Custom")
        }
    }

    fun addCity(fromDialog: String) {
        val arguments = fromDialog.split(',')
        cities.add( City(arguments[0], arguments[1]))
        updateAdapter()
    }

    fun addCityFromResponse(response: WeatherResult?) {
        if (response != null) {
            val w1: Weather = Weather().apply { situation = "Cloudy"; temperature = 30.0; pressure = 1000; humidity = 81;
                windSpeed = 4.6; small_day_first = "SAT"; small_temperature_first = 30.0; small_day_second = "SUN"; small_temperature_second = 30.0;
                small_day_third = "MON"; small_temperature_third = 29.0; small_day_fourth = "TUE"; small_temperature_fourth = 29.0;
                small_day_fifth = "WED"; small_temperature_fifth = 30.0;}

            cities.add(City(response.name, response.sys.country).apply { weather = w1 })
        }
    }

    fun updateAdapter() {
        adapter!!.notifyDataSetChanged()
    }

    fun initializeAdapter(){
        adapter = CityAdapter(cities, activity)
    }

    private fun initializeLayoutManager(){
        recyclerview_fragment_cities?.layoutManager = LinearLayoutManager(context)
    }

    private fun initializeRecyclerView(){
        recyclerview_fragment_cities?.adapter = adapter
    }





    fun initializeData(): ArrayList<City> {
        if (cities.size == 0) {
            val w1: Weather = Weather().apply {
                situation = "Cloudy"; temperature = 24.8; pressure = 1021; humidity =
                69; backgroundColor = R.color.colorCloudy;
                windSpeed = 3.2; small_day_first = "WED"; small_situation_icon_first =
                R.drawable.ic_baseline_cloud_queue_24; small_temperature_first = 26.1;
                small_day_second = "THU"; small_temperature_second =
                28.8; small_situation_icon_second = R.drawable.ic_baseline_sunny;
                small_day_third = "FRI"; small_temperature_third = 25.5;small_situation_icon_third =
                R.drawable.ic_baseline_thunder;
                small_day_fourth = "SAT"; small_temperature_fourth =
                29.0;small_situation_icon_fourth = R.drawable.ic_baseline_sunny_cloud;
                small_day_fifth = "SUN"; small_temperature_fifth = 30.7;small_situation_icon_fifth =
                R.drawable.ic_baseline_sunny;
            }

            cities.add(City("London", "uk").apply { weather = w1 })

            val w2: Weather = Weather().apply {
                situation = "Sunny"; temperature = 24.8; pressure = 1021; humidity =
                69; situationIcon = R.drawable.ic_baseline_sunny; backgroundColor =
                R.color.colorSunny;
                windSpeed = 3.2; small_day_first = "WED"; small_situation_icon_first =
                R.drawable.ic_baseline_cloud_queue_24; small_temperature_first = 26.1;
                small_day_second = "THU"; small_temperature_second =
                28.8; small_situation_icon_second = R.drawable.ic_baseline_sunny;
                small_day_third = "FRI"; small_temperature_third = 25.5;small_situation_icon_third =
                R.drawable.ic_baseline_thunder;
                small_day_fourth = "SAT"; small_temperature_fourth =
                29.0;small_situation_icon_fourth = R.drawable.ic_baseline_sunny_cloud;
                small_day_fifth = "SUN"; small_temperature_fifth = 30.7;small_situation_icon_fifth =
                R.drawable.ic_baseline_sunny;
            }


            cities.add(City("Russia", "ru").apply { weather = w2 })

            val w3: Weather = Weather().apply {
                situation = "Rainy"; temperature = 24.8; pressure = 1021; humidity =
                69; situationIcon = R.drawable.ic_baseline_rainy_24; backgroundColor =
                R.color.colorRainy;
                windSpeed = 3.2; small_day_first = "WED"; small_situation_icon_first =
                R.drawable.ic_baseline_cloud_queue_24; small_temperature_first = 26.1;
                small_day_second = "THU"; small_temperature_second =
                28.8; small_situation_icon_second = R.drawable.ic_baseline_sunny;
                small_day_third = "FRI"; small_temperature_third = 25.5;small_situation_icon_third =
                R.drawable.ic_baseline_thunder;
                small_day_fourth = "SAT"; small_temperature_fourth =
                29.0;small_situation_icon_fourth = R.drawable.ic_baseline_sunny_cloud;
                small_day_fifth = "SUN"; small_temperature_fifth = 30.7;small_situation_icon_fifth =
                R.drawable.ic_baseline_sunny;
            }


            cities.add(City("Kazakhstan", "kz").apply { weather = w3 })

            val w4: Weather = Weather().apply {
                situation = "Storm"; temperature = 24.8; pressure = 1021; humidity =
                69; situationIcon = R.drawable.ic_baseline_thunder; backgroundColor =
                R.color.colorStorm;
                windSpeed = 10.1; small_day_first = "WED"; small_situation_icon_first =
                R.drawable.ic_baseline_cloud_queue_24; small_temperature_first = 26.1;
                small_day_second = "THU"; small_temperature_second =
                28.8; small_situation_icon_second = R.drawable.ic_baseline_sunny;
                small_day_third = "FRI"; small_temperature_third = 25.5;small_situation_icon_third =
                R.drawable.ic_baseline_thunder;
                small_day_fourth = "SAT"; small_temperature_fourth =
                29.0;small_situation_icon_fourth = R.drawable.ic_baseline_sunny_cloud;
                small_day_fifth = "SUN"; small_temperature_fifth = 30.7;small_situation_icon_fifth =
                R.drawable.ic_baseline_sunny;
            }


            cities.add(City("Brazilia", "br").apply { weather = w4 })
        }
        return cities
    }
}