package com.example.education.data

import com.example.education.domain.usecase.function.sort.CurrencyObject
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET(ApiConstants.WEATHER)
    fun initiateGetWeather() : Observable<Response<CurrencyObject>>
}

