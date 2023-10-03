package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.viewmodel.MovieViewModel

@Composable
fun MovieDetailScreen(movieId: Int, viewModel: MovieViewModel) {
    //val movieDetail by viewModel.getMovieDetail(movieId).observeAsState()
    //val lastViewedMovie = viewModel.lastViewedMovie

    LaunchedEffect(Unit){
        viewModel.getMovieDetailViewModel(movieId)
    }



    if (viewModel.movieDetail.title != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            /*${movie.year}
            * ${movie.id}*/
            Text(text = "movie ${viewModel.movieDetail.title}", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
            Text(text = "Year: ${viewModel.movieDetail.release_date}", style = TextStyle(fontSize = 18.sp))
            Text(text = "Description:  ${viewModel.movieDetail.tagline}", style = TextStyle(fontSize = 18.sp))
            Spacer(modifier = Modifier.height(16.dp))
            /*if (lastViewedMovie != null && lastViewedMovie.id != movie.id) {
                Text(
                    text = "Last viewed: ${lastViewedMovie.title}",
                    style = TextStyle(fontSize = 18.sp, fontStyle = FontStyle.Italic)
                )
            }*/
        }
    } else {
        Text("Movie not found")
   }
}