package com.example.education.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class City (
    val name1: String,
    val countryCode1: String
) {
    @PrimaryKey(autoGenerate = true) var cityId: Int = 0
    var name = name1
    var countyCode = countryCode1
    var weather: Weather = Weather()
}