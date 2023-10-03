package com.example.myapplication.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {
    private const val BASE_URL = "https://api.themoviedb.org/"

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        // TODO: Decide logging logic
                        HttpLoggingInterceptor().apply {
                            setLevel(HttpLoggingInterceptor.Level.BODY)
                        }
                    )
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}