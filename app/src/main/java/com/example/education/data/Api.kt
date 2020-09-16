package com.example.education.data

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET(ApiConstants.LATEST_RATES)
    fun initiateGetRates() : Observable<Response<Student>>

}