package com.example.myapplication.data

import com.example.myapplication.api.MovieApiService
import com.example.myapplication.api.RetrofitClient
import com.example.myapplication.data.model.GetMovieByIdResponse
import com.example.myapplication.data.model.GetMovieResponse

class MovieRepository {
    private val movieApiService: MovieApiService = RetrofitClient.instance.create(MovieApiService::class.java)
    val apiKey = "ab01a3bfec4d67c242edfb82aee61180"
    suspend fun getMovies(): GetMovieResponse {
        return try {
            movieApiService.getMovies(apiKey)
        } catch (e: Exception) {
            // Handle network errors here
            GetMovieResponse(null,null,null,null)
        }
    }

    suspend fun getMovieDetail(movieId: Int): GetMovieByIdResponse {
        return try {
            movieApiService.getMovieDetail(movieId, apiKey)
        } catch (e: Exception) {
            // Handle network errors here
            GetMovieByIdResponse(null,null,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null
                ,null)
        }
    }
}