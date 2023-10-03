package com.example.myapplication.data.model

data class GetMovieResponse(
    var page: Int?,
    var results: List<Movie>?,
    var total_pages: Int?,
    var total_results: Int?
)