package com.example.education.domain.usecase.function.sort

import com.example.education.data.WeatherRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RequestCurrencyUseCase : BaseUseCase<CurrencyObject> {

    lateinit var ratesDomainRepository: WeatherDomainRepository

    constructor() : super(Schedulers.io(), AndroidSchedulers.mainThread()){
        this.ratesDomainRepository = WeatherRepository()
    }

    override fun createObservableObject(): Observable<CurrencyObject> {
        return ratesDomainRepository.initiateGetWeather()
    }
}