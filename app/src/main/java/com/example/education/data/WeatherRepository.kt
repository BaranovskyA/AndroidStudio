package com.example.education.data

import com.example.education.domain.usecase.function.sort.CurrencyObject
import io.reactivex.Observable
import com.example.education.domain.usecase.function.sort.WeatherDomainRepository
import java.lang.Exception

class WeatherRepository: WeatherDomainRepository {
    lateinit var apiImplementation: ApiImplementation

    constructor() {
        apiImplementation = ApiImplementation()
    }

    override fun initiateGetWeather(): Observable<CurrencyObject> {
        return apiImplementation.initiateGetWeather().map {response ->
            if(response.isSuccessful)
                response.body()
            else
                throw Exception()
        }
    }
}