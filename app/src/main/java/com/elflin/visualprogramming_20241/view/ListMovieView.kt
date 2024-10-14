package com.elflin.visualprogramming_20241.view

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.elflin.visualprogramming_20241.viewmodel.ListMovieViewModel

@Composable
fun ListMovieView(
    modifier: Modifier = Modifier,
    viewModel: ListMovieViewModel = viewModel()
){

    val movies by viewModel.movies.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items(movies){ movie ->
            MovieCard(
                movie,
                onLikeClick = { viewModel.toggleButtonLike(movie) }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ListMoviePreview(){
    ListMovieView()
}