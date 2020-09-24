package com.practic.studentfragment.domain.usecase

import com.practic.studentfragment.data.repository.CurrencyRepository
import com.practic.studentfragment.domain.CurrencyDomainRepository
import com.practic.studentfragment.domain.CurrencyObject
import com.practic.studentfragment.domain.base.BaseNetworkUseCase
import io.reactivex.Observable

class GetCurrenciesUseCase() : BaseNetworkUseCase<CurrencyObject>() {

    private var currencyDomainRepository: CurrencyDomainRepository = CurrencyRepository()

    override fun initiateCreateObservable(): Observable<CurrencyObject> {
        return currencyDomainRepository.initiateGetCurrency()
    }
}