package com.practic.studentfragment.domain

import io.reactivex.Observable

interface CurrencyDomainRepository {
    fun initiateGetCurrency(): Observable<CurrencyObject>
}