package com.example.education.domain.usecase.function.sort

import com.example.education.data.WeatherRepository
import com.example.education.presentation.activity.BaseActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RequestCurrentWeatherUseCase() :
    BaseUseCase<WeatherResult>(Schedulers.io(), AndroidSchedulers.mainThread()) {

    var ratesDomainRepository: WeatherDomainRepository = WeatherRepository()

    override fun createObservableObject(): Observable<WeatherResult> {
        return ratesDomainRepository.initiateGetWeather()
    }
}