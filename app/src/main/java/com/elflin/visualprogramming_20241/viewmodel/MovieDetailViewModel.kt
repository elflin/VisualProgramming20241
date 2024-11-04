package com.elflin.visualprogramming_20241.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elflin.visualprogramming_20241.data.DataSource
import com.elflin.visualprogramming_20241.model.Movie
import com.elflin.visualprogramming_20241.repository.MovieDBContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel: ViewModel() {

    private val _movie = MutableStateFlow<Movie>(Movie())
    val movie: StateFlow<Movie> = _movie

    fun setMovie(id: Int){
        viewModelScope.launch {
            val movie = MovieDBContainer().movieDBRepositories.getMovieDetail(id)

            Log.d("CheckDate", movie.releaseDate.toString())

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