package com.example.education.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.education.R
import com.example.education.data.City
import com.example.education.data.Weather
import com.example.education.presentation.activity.BaseActivity
import com.example.education.presentation.holders.WeatherViewHolder

class WeatherAdapter(var city: City, private val activity: BaseActivity) : RecyclerView.Adapter<WeatherViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_weather, parent, false)
        return WeatherViewHolder(view)
    }

    override fun getItemCount(): Int { return 1 }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bindView(city, activity)
    }
}