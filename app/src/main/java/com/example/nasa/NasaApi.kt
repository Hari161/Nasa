package com.example.nasa

import com.example.nasa.Response.Nasamainresponse
import retrofit2.Response
import retrofit2.http.GET

interface NasaApi {
    @GET("apod?api_key=DEMO_KEY&count=10")
    suspend fun setRequest(): Response<Nasamainresponse>
}