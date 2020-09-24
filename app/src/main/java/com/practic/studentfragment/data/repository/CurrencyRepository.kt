package com.practic.studentfragment.data.repository

import com.practic.studentfragment.data.api.ApiImplementation
import com.practic.studentfragment.domain.CurrencyDomainRepository
import com.practic.studentfragment.domain.CurrencyObject
import io.reactivex.Observable

class CurrencyRepository() : CurrencyDomainRepository {

    var apiImplementation: ApiImplementation = ApiImplementation()

    override fun initiateGetCurrency(): Observable<CurrencyObject> {
        return apiImplementation.initiateGetСurrency()
            .map { response ->
                if(response.isSuccessful){
                    response.body()
                }else{
                    throw Exception()
                }
            }
    }
}