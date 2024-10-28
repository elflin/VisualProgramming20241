package com.elflin.visualprogramming_20241.service

import com.elflin.visualprogramming_20241.model.NowPlaying
import com.elflin.visualprogramming_20241.model.Result
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDBService {

    @GET("now_playing")
    suspend fun getNowPlaying(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US"
    ): NowPlaying

    @GET("popular")
    suspend fun getPopular(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US"
    ): NowPlaying

    @GET("{movie_id}")
    suspend fun getDetailMovie(
        @Path("movie_id") movieId: Int
    ): Result

}