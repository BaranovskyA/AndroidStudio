package com.example.education.data

import com.example.education.domain.usecase.function.sort.WeatherResult
import io.reactivex.Observable
import com.example.education.domain.usecase.function.sort.WeatherDomainRepository
import java.lang.Exception

class WeatherRepository() : WeatherDomainRepository {
    var apiImplementation: ApiImplementation

    init {
        apiImplementation = ApiImplementation()
    }

    override fun initiateGetWeather(): Observable<WeatherResult> {
        return apiImplementation.initiateGetWeather().map { response ->
            if(response.isSuccessful)
                response.body()
            else
                throw Exception()
        }
    }
}