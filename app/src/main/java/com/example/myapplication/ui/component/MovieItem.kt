package com.example.myapplication.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.model.Movie

@Composable
fun MovieItem(movie: Movie, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onItemClick), // Handle item click
        //elevation = CardElevation(defa)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Year: ${movie.release_date}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }
}





