package com.elflin.visualprogramming_20241.viewmodel

import androidx.lifecycle.ViewModel
import com.elflin.visualprogramming_20241.data.DataSource
import com.elflin.visualprogramming_20241.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ListMovieViewModel: ViewModel() {

    // Set
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    // Get
    val movies: StateFlow<List<Movie>> = _movies

    init {
        loadMovies()
    }

    private fun loadMovies(){
        _movies.value = DataSource().loadMovie()
    }

    fun toggleButtonLike(movie: Movie){
        _movies.value = _movies.value.map {
            if (it.title == movie.title){
                it.copy(isLiked = !it.isLiked)
            }else{
                it
            }
        }
    }
}