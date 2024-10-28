package com.elflin.visualprogramming_20241.repository

import com.elflin.visualprogramming_20241.model.Movie
import com.elflin.visualprogramming_20241.model.Result
import com.elflin.visualprogramming_20241.service.MovieDBService
import java.text.SimpleDateFormat

class MovieDBRepositories(private val movieDBService: MovieDBService) {

    suspend fun getNowPlaying(page: Int = 1, language: String = "en-US"): List<Result>{
        return movieDBService.getNowPlaying(page, language).results
    }

    suspend fun getMovieDetail(movieId: Int): Movie{
        val respond = movieDBService.getDetailMovie(movieId)

        val movie = Movie(
            overview = respond.overview,
            posterPath = respond.poster_path,
            releaseDate = SimpleDateFormat("yyyy-MM-dd").parse(respond.release_date),
            title = respond.title,
            voteAverage = respond.vote_average.toFloat(),
            voteCount = respond.vote_count,
            isLiked = false
        )

        return movie
    }
}