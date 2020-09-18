package com.example.education.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.education.R
import com.example.education.data.City
import com.example.education.data.Weather
import com.example.education.presentation.holders.CityViewHolder

class CityAdapter( var cities: ArrayList<City> = ArrayList()) : RecyclerView.Adapter<CityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_city, parent, false)
        return CityViewHolder(view)
    }

    override fun getItemCount(): Int { return cities.size }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bindView(cities[position])
    }
}