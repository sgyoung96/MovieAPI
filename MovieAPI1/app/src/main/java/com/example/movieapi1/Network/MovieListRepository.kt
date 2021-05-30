package com.example.movieapi1.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieListRepository {
    private var retrofit: Retrofit? = null
    private var movieInfoOpenApiService: MovieInfoOpenApiService? = null

    fun initBuild() : MovieInfoOpenApiService? {
        retrofit = Retrofit.Builder().baseUrl(Info.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()).build()
        movieInfoOpenApiService = retrofit?.create(MovieInfoOpenApiService::class.java)
        return movieInfoOpenApiService
    }
}