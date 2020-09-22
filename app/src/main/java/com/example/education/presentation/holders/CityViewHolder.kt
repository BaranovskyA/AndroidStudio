package com.example.education.presentation.holders

import android.annotation.SuppressLint
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.education.R
import com.example.education.data.City
import com.example.education.presentation.activity.BaseActivity
import com.example.education.presentation.fragments.WeatherFragment
import kotlinx.android.synthetic.main.fragment_item_city.view.*
import java.util.*

class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @SuppressLint("SetTextI18n", "CheckResult")
    fun bindView(city: City, activity: BaseActivity) {
        itemView.imageview_fragment_item_city_icon.setImageResource(city.weather.situationIcon)
        itemView.constraintlayout_fragment_item_city.setBackgroundColor(ContextCompat.getColor(activity.applicationContext, city.weather.backgroundColor))
        itemView.textview_fragment_item_city_temperature.text = "${city.weather.temperature} °C"
        itemView.textview_fragment_item_city_name.text = "${city.name},${city.countyCode.toUpperCase(Locale.ROOT)}"
        itemView.textview_fragment_item_city_situation.text = city.weather.situation
        itemView.setOnClickListener {
            activity.weatherFragment = WeatherFragment(city, activity)
            activity.supportFragmentManager
                .beginTransaction()
                .add(R.id.linearlayout_activity_main_container, activity.weatherFragment)
                .remove(activity.cityFragment)
                .commit()
        }
    }
}