package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.ui.screens.MovieDetailScreen
import com.example.myapplication.ui.screens.MovieListScreen
import com.example.myapplication.viewmodel.MovieViewModel

@Composable
fun MovieAppNavHost(navController: NavHostController, startDestination:String,viewModel: MovieViewModel) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(startDestination) {
            MovieListScreen(navController, viewModel) { movieId ->
                navController.navigate("movie/$movieId")
            }
        }
        composable(
            "movie/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val movieId = arguments.getInt("movieId")
            MovieDetailScreen(movieId, viewModel)
        }
    }
}




