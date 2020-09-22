package com.example.education.domain.usecase.function.sort

import io.reactivex.Observable

interface WeatherDomainRepository {
    fun initiateGetWeather(): Observable<WeatherResult>
}