package com.example.constraintlayout.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

object ApiClient1 {
    private val URL = "https:/192.168.10.241:8080/"

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}