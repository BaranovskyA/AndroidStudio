package com.practic.studentfragment.data.api

import com.practic.studentfragment.domain.CurrencyObject
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET(ApiConstants.LATEST_RATES)
    fun initiateGetСurrency(): Observable<Response<CurrencyObject>>

    @GET(ApiConstants.LATEST_RATES)
    fun initiateGetСurrency(@Query("base") currencyName: String): Observable<Response<CurrencyObject>>

}