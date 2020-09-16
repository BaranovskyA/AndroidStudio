package com.example.education.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiConnection {
    fun initializeRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .client(initializeOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun initializeAPIObject(): Api{
        return initializeRetrofit().create(Api::class.java)
    }

    fun initializeOkHttpClient() : OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .readTimeout(30000, TimeUnit.MILLISECONDS)
            .connectTimeout(30000, TimeUnit.MILLISECONDS)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    HttpLoggingInterceptor.Level.BASIC
                }).build()
    }
}