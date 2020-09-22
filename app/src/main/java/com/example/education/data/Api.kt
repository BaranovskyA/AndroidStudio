package com.example.education.data

import com.example.education.domain.usecase.function.sort.WeatherResult
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET(ApiConstants.CURRENT_WEATHER)
    fun initiateGetWeather() : Observable<Response<WeatherResult>>
}

