package com.practic.studentfragment.data.api

import com.practic.studentfragment.domain.CurrencyObject
import io.reactivex.Observable
import retrofit2.Response

class ApiImplementation() : Api {

    var api: Api = ApiConnection().initializeAPIObject()

    override fun initiateGetСurrency(): Observable<Response<CurrencyObject>> {
        return api.initiateGetСurrency()
    }

    override fun initiateGetСurrency(currencyName: String): Observable<Response<CurrencyObject>> {
        return api.initiateGetСurrency(currencyName)
    }

}