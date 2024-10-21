package com.elflin.visualprogramming_20241.viewmodel

import androidx.lifecycle.ViewModel
import com.elflin.visualprogramming_20241.data.DataSource
import com.elflin.visualprogramming_20241.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MovieDetailViewModel: ViewModel() {

    private val _movie = MutableStateFlow<Movie>(Movie())
    val movie: StateFlow<Movie> = _movie

    fun setMovie(title: String){
        // Proses penarikan data dari sumber
        val movies = DataSource().loadMovie()

        for (movie in movies){
            if (movie.title == title){
                _movie.value = _movie.value.copy(
                    movie.overview,
                    movie.posterPath,
                    movie.releaseDate,
                    movie.title,
                    movie.voteAverage,
                    movie.voteCount,
                    movie.isLiked
                )
            }
        }
    }
}