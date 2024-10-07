package com.elflin.visualprogramming_20241.view

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.elflin.visualprogramming_20241.data.DataSource
import com.elflin.visualprogramming_20241.model.Movie

@Composable
fun ListMovieView(
    movies: List<Movie>,
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items ( movies.size ) { index ->
            MovieCard(movies[index])
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ListMoviePreview(){
    ListMovieView(DataSource().loadMovie())
}