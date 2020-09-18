package com.example.education.presentation.holders

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.education.data.City
import com.example.education.data.Weather
import kotlinx.android.synthetic.main.fragment_item_city.view.*
import java.util.*

class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n")
    fun bindView(city: City) {
        itemView.imageview_fragment_item_city_icon.setImageResource(city.weather.situationIcon)
        itemView.setBackgroundColor(city.weather.backgroundColor)
        itemView.textview_fragment_item_city_temperature.text = "${city.weather.temperature} °C"
        itemView.textview_fragment_item_city_name.text = "${city.name},${city.countyCode.toUpperCase(Locale.ROOT)}"
        itemView.textview_fragment_item_city_situation.text = city.weather.situation
    }
}