package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.data.model.Movie
import com.example.myapplication.ui.component.MovieItem
import com.example.myapplication.viewmodel.MovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(
    navController: NavController,
    viewModel: MovieViewModel,
    onMovieSelected: (Int) -> Unit
) {
    val allMovies by remember {mutableStateOf(viewModel.movies)}
    var filteredMovies by remember { mutableStateOf(viewModel.movies) }
    var filterText by remember { mutableStateOf("") }

    Column {
        TextField(
            value = filterText,
            onValueChange = { text ->
                filterText = text
                filteredMovies = if (text.isEmpty()) {
                    viewModel.movies
                } else
                {
                    viewModel.filteredMovies.clear()
                    viewModel.filteredMovies.addAll(viewModel.movies.filter { it.title.contains(text, ignoreCase = true) }.toList())
                    viewModel.filteredMovies
                }
            },
            placeholder = { Text("Filter by name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        LazyColumn {
            items(filteredMovies.size) { movie ->
                MovieItem(filteredMovies[movie]) {
                    onMovieSelected(filteredMovies[movie].id)
                }
            }
        }
    }
}