package com.example.myapplication.viewmodel;

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.MovieRepository
import com.example.myapplication.data.model.GetMovieByIdResponse
import com.example.myapplication.data.model.GetMovieResponse
import com.example.myapplication.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MovieViewModel : ViewModel() {
    private val movieRepository = MovieRepository()
    var movies = mutableStateListOf<Movie>()
    var filteredMovies = mutableStateListOf<Movie>()
    var movieDetail = GetMovieByIdResponse(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)
    init {
        viewModelScope.launch {
           getMovies().collect { result ->

               movies.clear()
               movies.addAll(result.results!!)
               filteredMovies.clear()
               filteredMovies.addAll(result.results!!)
            }
        }
    }

    suspend fun getMovies(): Flow<GetMovieResponse> = flow {
        emit(movieRepository.getMovies())
    }

    fun getMovieDetailViewModel(movieId: Int)
    {
        viewModelScope.launch {
            getMovieDetail(movieId).collect { result ->

                movieDetail = result
            }
        }

    }
    suspend fun getMovieDetail(movieId: Int): Flow<GetMovieByIdResponse> = flow {

        emit(movieRepository.getMovieDetail(movieId))


    }
}