package com.example.movieapi1.Network

import com.example.movieapi1.Network.model.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInfoOpenApiService {
    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    fun getBoxOffice(
        @Query("key")key: String,
        @Query("targetDt")target: String?
    ): Call<Results>
}