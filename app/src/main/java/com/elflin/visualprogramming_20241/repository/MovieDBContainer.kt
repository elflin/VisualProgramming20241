package com.elflin.visualprogramming_20241.repository

import com.elflin.visualprogramming_20241.service.MovieDBService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieDBContainer {

    companion object{
        val BASE_IMG = "https://image.tmdb.org/t/p/w500/"
    }

    private val BASE_URL = "https://api.themoviedb.org/3/movie/"
    private val ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiZDJjNzcxM2ZkZjA5MTIxN2IzMWE5OTRkM2E4ZmI5YSIsIm5iZiI6MTczMDY5Mjc5OC4zMzgwNzEzLCJzdWIiOiI2Mjg0N2VmNWNkMjA0NjAwYThiNWUzYjIiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.yRqWYYsWgmeWD-xMCg02SLPwZHfiub7Q72wb0tqa2ZE"

    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(ACCESS_TOKEN))
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    private val retrofitService: MovieDBService by lazy {
        retrofit.create(MovieDBService::class.java)
    }

    val movieDBRepositories: MovieDBRepositories by lazy {
        MovieDBRepositories(retrofitService)
    }

}