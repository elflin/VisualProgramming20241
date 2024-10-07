package com.elflin.visualprogramming_20241.model

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

data class Movie(
    val overview: String,
    val posterPath: String = "",
    val releaseDate: Date,
    val title: String,
    val voteAverage: Float,
    val voteCount: Int,
    var isLiked: Boolean = false
) {

    @SuppressLint("SimpleDateFormat")
    fun getYear(): String {
        return SimpleDateFormat("yyyy").format(releaseDate)
    }
}