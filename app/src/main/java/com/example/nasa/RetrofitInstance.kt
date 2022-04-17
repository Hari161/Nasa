package com.example.nasa

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
object RetrofitInstance {
    val BASE_URL = "https://api.nasa.gov/planetary/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}