package com.example.education.presentation.holders

import android.annotation.SuppressLint
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.education.R
import com.example.education.data.City
import com.example.education.presentation.activity.BaseActivity
import kotlinx.android.synthetic.main.fragment_item_weather.view.*
import java.util.*
import kotlin.math.roundToInt

class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n", "ResourceAsColor")
    fun bindView(city: City, activity: BaseActivity) {
        itemView.imageview_fragment_item_weather_icon.setImageResource(city.weather.situationIcon)
        itemView.constraintlayout_fragment_item_weather.setBackgroundColor(ContextCompat.getColor(activity.applicationContext, city.weather.backgroundColor))
        itemView.textview_fragment_item_weather.text = "${city.name},${city.countyCode.toUpperCase(Locale.ROOT)}"
        itemView.textview_fragment_item_weather_situation.text = city.weather.situation.toUpperCase(Locale.ROOT)
        itemView.textview_fragment_item_weather_temperature.text = "${city.weather.temperature.roundToInt()} °C"
        itemView.textview_fragment_item_weather_pressure.text = "${city.weather.pressure}hpa"
        itemView.textview_fragment_item_weather_watering.text = "${city.weather.humidity} %"
        itemView.textview_fragment_item_weather_wind.text = "${city.weather.windSpeed} m/s"

        itemView.textview_fragment_item_weather_small_first.text = city.weather.small_day_first.toUpperCase(
                Locale.ROOT).substring(0,3)
        itemView.textview_fragment_item_weather_small_temperature_first.text = "${city.weather.small_temperature_first} °C"
        itemView.imageview_fragment_item_weather_icon_small_first.setImageResource(city.weather.small_situation_icon_first)

        itemView.textview_fragment_item_weather_small_second.text = city.weather.small_day_second.toUpperCase(
            Locale.ROOT).substring(0,3)
        itemView.textview_fragment_item_weather_small_temperature_second.text = "${city.weather.small_temperature_second} °C"
        itemView.imageview_fragment_item_weather_icon_small_second.setImageResource(city.weather.small_situation_icon_second)

        itemView.textview_fragment_item_weather_small_third.text = city.weather.small_day_third.toUpperCase(
            Locale.ROOT).substring(0,3)
        itemView.textview_fragment_item_weather_small_temperature_third.text = "${city.weather.small_temperature_third} °C"
        itemView.imageview_fragment_item_weather_icon_small_third.setImageResource(city.weather.small_situation_icon_third)

        itemView.textview_fragment_item_weather_small_fourth.text = city.weather.small_day_fourth.toUpperCase(
            Locale.ROOT).substring(0,3)
        itemView.textview_fragment_item_weather_small_temperature_fourth.text = "${city.weather.small_temperature_fourth} °C"
        itemView.imageview_fragment_item_weather_icon_small_fourth.setImageResource(city.weather.small_situation_icon_fourth)

        itemView.textview_fragment_item_weather_small_fifth.text = city.weather.small_day_fifth.toUpperCase(
            Locale.ROOT).substring(0,3)
        itemView.textview_fragment_item_weather_small_temperature_fifth.text = "${city.weather.small_temperature_fifth} °C"
        itemView.imageview_fragment_item_weather_icon_small_fifth.setImageResource(city.weather.small_situation_icon_fifth)

        itemView.imageview_fragment_item_weather_menu.setOnClickListener {
            activity.supportFragmentManager
                .beginTransaction()
                .add(R.id.linearlayout_activity_main_container, activity.cityFragment)
                .remove(activity.weatherFragment)
                .commit()
        }
    }
}