package com.elflin.visualprogramming_20241.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elflin.visualprogramming_20241.data.DataSource
import com.elflin.visualprogramming_20241.model.Movie
import com.elflin.visualprogramming_20241.model.Result
import com.elflin.visualprogramming_20241.repository.MovieDBContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListMovieViewModel: ViewModel() {

    // Set
    private val _movies = MutableStateFlow<List<Result>>(emptyList())
    // Get
    val movies: StateFlow<List<Result>> = _movies

    init {
        loadMovies()
    }

    private fun loadMovies(){

        viewModelScope.launch {
            val data = MovieDBContainer().movieDBRepositories.getNowPlaying()
            _movies.value = data
        }
    }

    fun toggleButtonLike(movie: Result){
        _movies.value = _movies.value.map {
            if (it.title == movie.title){
                it.copy()
            }else{
                it
            }
        }
    }
}