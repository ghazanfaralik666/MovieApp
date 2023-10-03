package com.example.myapplication.api

import com.example.myapplication.data.model.GetMovieByIdResponse
import com.example.myapplication.data.model.GetMovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    @GET("3/movie/popular")
    suspend fun getMovies(@Query("api_key") apiKey: String): GetMovieResponse

    @GET("3/movie/{movieId}")
    suspend fun getMovieDetail(@Path("movieId") movieId: Int,@Query("api_key") apiKey: String): GetMovieByIdResponse
}