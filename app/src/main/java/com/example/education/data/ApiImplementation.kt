package com.example.education.data

import io.reactivex.Observable
import retrofit2.Response

class ApiImplementation : Api{

    var api: Api

    constructor(){
        api = ApiConnection().initializeAPIObject()
    }

    override fun initiateGetRates(): Observable<Response<Student>> {
        return api.initiateGetRates()
    }
}