package com.example.education.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.education.R

@Entity
class Weather {
    @PrimaryKey(autoGenerate = true) var weatherId: Int = 0
    var situationIcon: Int = R.drawable.ic_baseline_cloud_queue_24
    var backgroundColor: Int = R.color.colorCloudy
    var situation: String = ""
    var temperature: Double = 0.0
    var pressure: Int = 0
    var humidity: Int = 0
    var windSpeed: Double = 0.0

    var small_day_first: String = ""
    var small_situation_icon_first: Int = R.drawable.ic_baseline_cloud_queue_24
    var small_temperature_first: Double = 0.0

    var small_day_second: String = ""
    var small_situation_icon_second: Int = R.drawable.ic_baseline_cloud_queue_24
    var small_temperature_second: Double = 0.0

    var small_day_third: String = ""
    var small_situation_icon_third: Int = R.drawable.ic_baseline_cloud_queue_24
    var small_temperature_third: Double = 0.0

    var small_day_fourth: String = ""
    var small_situation_icon_fourth: Int = R.drawable.ic_baseline_cloud_queue_24
    var small_temperature_fourth: Double = 0.0

    var small_day_fifth: String = ""
    var small_situation_icon_fifth: Int = R.drawable.ic_baseline_cloud_queue_24
    var small_temperature_fifth: Double = 0.0
}