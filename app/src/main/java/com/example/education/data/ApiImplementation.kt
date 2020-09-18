package com.example.education.data

import com.example.education.domain.usecase.function.sort.CurrencyObject
import io.reactivex.Observable
import retrofit2.Response

class ApiImplementation : Api{

    var api: Api

    constructor(){
        api = ApiConnection().initializeAPIObject()
    }

    override fun initiateGetWeather(): Observable<Response<CurrencyObject>> {
        return api.initiateGetWeather()
    }
}